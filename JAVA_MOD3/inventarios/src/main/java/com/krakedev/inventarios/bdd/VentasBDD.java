package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.inventarios.excepciones.KrakedevException;
import com.krakedev.inventarios.utils.ConexionBDD;
import com.krakedev.inventrarios.entidades.DetalleVentas;
import com.krakedev.inventrarios.entidades.Ventas;

public class VentasBDD {
	BigDecimal IVA = new BigDecimal(0.15);
	BigDecimal BD=new BigDecimal(0);
	public void insertar(Ventas venta) throws KrakedevException {
		Connection con=null;
		PreparedStatement ps=null,psDet=null,psHs=null,psUp = null;
		ResultSet rsClave=null;
		Date fechaActual = new Date();
	    Timestamp fechaHoraActual = new Timestamp(fechaActual.getTime());
		int codigoRS=0;
		try {
			con = ConexionBDD.obtenerCone();
			con.setAutoCommit(false);
			ps=con.prepareStatement("INSERT INTO cabecera_ventas (fecha, total_sin_iva, iva, total) VALUES"
					+ "(?, ?, ?, ?)",java.sql.Statement.RETURN_GENERATED_KEYS);
			ps.setTimestamp(1, fechaHoraActual);
			ps.setBigDecimal(2, BD);
			ps.setBigDecimal(3, BD);
			ps.setBigDecimal(4, BD);
			ps.executeUpdate();
			rsClave=ps.getGeneratedKeys();
			if(rsClave.next()) {
				codigoRS=rsClave.getInt(1);
			}
			
			ArrayList<DetalleVentas> detalleVentas = venta.getDetalleVenta();
			DetalleVentas detV;
			for(int i =0 ;i<detalleVentas.size();i++) {
				detV = detalleVentas.get(i);
				psDet=con.prepareStatement("INSERT INTO detalle_venta (cabecera_vt, producto, cantidad, precio_venta, subtotal, subtotal_con_iva) VALUES"
						+ "(?, ?, ?, ?, ?, ?)");
				psDet.setInt(1, codigoRS);
				psDet.setInt(2, detV.getProducto().getCodigo() );
				psDet.setInt(3, detV.getCantidad());
				psDet.setBigDecimal(4, detV.getProducto().getPrecioVenta());
				BigDecimal cs = new BigDecimal(detV.getCantidad());
				BigDecimal sb=detV.getProducto().getPrecioVenta().multiply(cs);
				psDet.setBigDecimal(5, sb);
				if(detV.getProducto().getTieneIva()) {
					BigDecimal sbI = sb.add(sb.multiply(IVA));
					psDet.setBigDecimal(6, sbI);
				}else {
					psDet.setBigDecimal(6, sb);
				}
				psDet.executeUpdate();
			}
			
			
			psUp = con.prepareStatement("UPDATE cabecera_ventas SET total_sin_iva=?, iva=?, total=? where codigocv=?");
		        for(DetalleVentas dt : venta.getDetalleVenta()) {
		        	psUp.setBigDecimal(1, dt.getProducto().getPrecioVenta());
		        	if(dt.getProducto().getTieneIva()) {
		        		psUp.setBigDecimal(2, IVA);
		        		BigDecimal mlV = dt.getProducto().getPrecioVenta().multiply(IVA);
		    	        BigDecimal tB = mlV.add(dt.getProducto().getPrecioVenta());
		    	        BigDecimal cB = new BigDecimal(dt.getCantidad());
		    	        BigDecimal t = tB.multiply(cB);
		    	        psUp.setBigDecimal(3, t);
		        	}else {
		        		psUp.setBigDecimal(2, BD);
		        		psUp.setBigDecimal(3, dt.getProducto().getPrecioVenta().add(BD));
		        	}
		        	psUp.setInt(4, codigoRS);
		        	psUp.executeUpdate();
		        }

			 // Insert en historial stock
	        psHs = con.prepareStatement("INSERT INTO historial_stock (fecha, referencia, producto, cantidad) VALUES"
	        		+ "(?, ?, ?, ?)");
	        for(DetalleVentas dt : venta.getDetalleVenta()) {
	            psHs.setTimestamp(1, fechaHoraActual);
	            psHs.setString(2, "Venta "+venta.getCodigo());
	            psHs.setInt(3, dt.getProducto().getCodigo());
	            psHs.setInt(4, dt.getCantidad());
	            psHs.executeUpdate();
	        }
	        con.commit();
		} catch (KrakedevException e) {
			e.printStackTrace();
			throw e;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al insertar venta");
		}
	}
	
}
