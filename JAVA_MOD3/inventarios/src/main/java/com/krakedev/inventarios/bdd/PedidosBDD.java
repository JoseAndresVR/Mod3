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
import com.krakedev.inventrarios.entidades.DetallePedidos;
import com.krakedev.inventrarios.entidades.EstadoPedido;
import com.krakedev.inventrarios.entidades.Pedidos;
import com.krakedev.inventrarios.entidades.Productos;
import com.krakedev.inventrarios.entidades.Proveedores;

public class PedidosBDD {
	public void insertar(Pedidos pedido) throws KrakedevException {
		Connection con=null;
		PreparedStatement ps=null,psDet=null;
		ResultSet rsClave=null;
		int codigoRS=0;
		try {
			con = ConexionBDD.obtenerCone();
			ps=con.prepareStatement("INSERT INTO cabecera_pedido (proveedor, fecha, estado) VALUES "
					+ "( ?, ?, ?); ",java.sql.Statement.RETURN_GENERATED_KEYS);
			Date fechaActual = new Date();
			java.sql.Date fechaSQL = new java.sql.Date(fechaActual.getTime());
			ps.setInt(1, pedido.getProveedor().getInd());
			ps.setDate(2, fechaSQL);
			ps.setString(3, pedido.getEstadoPedido().getCodigo());
			ps.executeUpdate();
			rsClave=ps.getGeneratedKeys();
			if(rsClave.next()) {
				codigoRS=rsClave.getInt(1);
			}
			
			ArrayList<DetallePedidos> detallePedidos = pedido.getDetallesP();
			DetallePedidos det;
			for(int i =0 ;i<detallePedidos.size();i++) {
				det = detallePedidos.get(i);
				psDet=con.prepareStatement("INSERT INTO detalle_pedidos (cabecera_pd, producto, cantidad, subtotal, cantidad_recibida) VALUES"
						+ "( ?, ?, ?, ?, ?)");
				psDet.setInt(1, codigoRS);
				psDet.setInt(2, det.getProducto().getCodigo() );
				psDet.setInt(3, det.getCantidadSolicitada());
				psDet.setInt(4, 0);
				BigDecimal cs = new BigDecimal(det.getCantidadSolicitada());
				BigDecimal sb=det.getProducto().getPrecioVenta().multiply(cs);
				psDet.setBigDecimal(5, sb);
				psDet.executeUpdate();
			}
			
		} catch (KrakedevException e) {
			e.printStackTrace();
			throw e;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al insertar pedido");
		}
	}
	public void update(Pedidos pedido) throws KrakedevException {
	    Connection con = null;
	    PreparedStatement psDet = null,psCab = null,psHs=null;
	    Date fechaActual = new Date();
	    Timestamp fechaHoraActual = new Timestamp(fechaActual.getTime());
	    try {
	        con = ConexionBDD.obtenerCone();
	        con.setAutoCommit(false);
	        // Actualizar los detalles de los pedidos
	        psDet = con.prepareStatement("UPDATE detalle_pedidos SET cantidad_recibida=?, subtotal=? WHERE codigodp=?");
	        for (DetallePedidos ped : pedido.getDetallesP()) {
	            psDet.setInt(1, ped.getCatidadRecibida());
	            psDet.setBigDecimal(2, ped.getSubtotal());
	            psDet.setInt(3, ped.getCodigo());
	            psDet.executeUpdate();
	        }

	        // Actualizar el estado del pedido
	        psCab = con.prepareStatement("UPDATE cabecera_pedido SET estado=? WHERE numerocp = ?");
	        psCab.setString(1, "E");
	        psCab.setInt(2, pedido.getNumero());
	        psCab.executeUpdate();
	        
	        // Insert en historial stock
	        psHs = con.prepareStatement("INSERT INTO historial_stock (fecha, referencia, producto, cantidad) VALUES"
	        		+ "(?, ?, ?, ?)");
	        for(DetallePedidos ped : pedido.getDetallesP()) {
	            psHs.setTimestamp(1, fechaHoraActual);
	            psHs.setString(2, "Pedido "+pedido.getNumero());
	            psHs.setInt(3, ped.getProducto().getCodigo());
	            psHs.setInt(4, ped.getCantidadSolicitada());
	            psHs.executeUpdate();
	        }
	        con.commit();

	    }catch (KrakedevException e) {
			e.printStackTrace();
			throw e; 
		}catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al actualizar el detalle del pedido");
		}
	}
	
	public ArrayList<Pedidos> pedidosPorProv(int ind) throws KrakedevException{
		ArrayList<Pedidos> pedidos = new ArrayList<Pedidos>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Pedidos ped=null;
		try {
			con = ConexionBDD.obtenerCone();
			ps = con.prepareStatement("select cb.numerocp as Numero_Cabecera,cb.proveedor as codigo_proveedor, cb.fecha, cb.estado,dt.cabecera_pd, "
					+ " dt.codigodp as codigo_pedido,dt.producto, CAST(dt.cantidad AS DECIMAL(5,2)),CAST(dt.subtotal AS DECIMAL(5,2)), dt.cantidad_recibida "
					+ " from cabecera_pedido cb,detalle_pedidos dt "
					+ " where cb.proveedor = ?");
			ps.setInt(1, ind);
			rs=ps.executeQuery();
			if(rs.next()) {
				int codigoCabecera = rs.getInt("Numero_Cabecera");
				int identificadorProveedor = rs.getInt("codigo_proveedor");
				Date fecha = rs.getDate("fecha");
				String estado = rs.getString("estado");
				int codigoProducto = rs.getInt("producto");
				int codigoPedido = rs.getInt("codigo_pedido");
				int cantidadSolicitada = rs.getInt("cantidad");
				BigDecimal subtotal = rs.getBigDecimal("subtotal");
				int cantidadRecibida = rs.getInt("cantidad_recibida");
				
				EstadoPedido estadoPedido = new EstadoPedido();
				estadoPedido.setCodigo(estado);
				
				Productos producto = new Productos();
				producto.setCodigo(codigoProducto);
				
				Proveedores proveedor = new Proveedores();
				proveedor.setInd(identificadorProveedor);
				
				ArrayList<DetallePedidos> dtA = new ArrayList<DetallePedidos>();
				DetallePedidos dt = new DetallePedidos();
				dt.setCantidadSolicitada(cantidadSolicitada);
				dt.setCatidadRecibida(cantidadRecibida);
				dt.setCodigo(codigoPedido);
				dt.setProducto(producto);
				dt.setSubtotal(subtotal);
				dtA.add(dt);
				ped = new Pedidos();
				ped.setEstadoPedido(estadoPedido);
				ped.setFecha(fecha);
				ped.setDetallesP(dtA);
				ped.setNumero(codigoCabecera);
				ped.setProveedor(proveedor);
				
				pedidos.add(ped);
				
				
			}
		} catch (KrakedevException e) {
			e.printStackTrace();
			throw e;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al consultar pedidos");
		}
		return pedidos;
	}
	
}
