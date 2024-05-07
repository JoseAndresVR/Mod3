package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.excepciones.KrakedevException;
import com.krakedev.inventarios.utils.ConexionBDD;
import com.krakedev.inventrarios.entidades.Productos;
import com.krakedev.inventrarios.entidades.UnidadesDeMedida;
import com.krakedev.inventrarios.entidades.categorias;

public class ProductosBDD {
	
	
	public ArrayList<Productos> buscar(String subcadena) throws KrakedevException{
		ArrayList<Productos> productos = new ArrayList<Productos>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Productos prod=null;
		try {
			con = ConexionBDD.obtenerCone();
			ps = con.prepareStatement("SELECT prod.codigop AS codigo_producto, prod.nombre_producto, "
				    + "udm.nombre_unidad_medida, udm.descripcion, CAST(prod.precio AS DECIMAL(6,2)), "
				    + "prod.tiene_iva, CAST(prod.coste AS DECIMAL(5,2)), prod.codigo_cat, cat.nombre_categoria, stock "
				    + "FROM productos prod, unidades_medida udm, categorias cat "
				    + "WHERE prod.codigo_udm = udm.nombre_unidad_medida "
				    + "AND prod.codigo_cat = cat.codigoca "
				    + "AND upper(prod.nombre_producto) LIKE ?");

			ps.setString(1, "%"+subcadena.toUpperCase()+"%");
			rs=ps.executeQuery();
			if(rs.next()) {
				int codigoProducto = rs.getInt("codigo_producto");
				String nombreProducto = rs.getString("nombre_producto");
				String	nombreUnidadMedida = rs.getString("nombre_unidad_medida");
				String descripcionUnidadMedida=rs.getString("descripcion");
				String nombreCategoria=rs.getString("nombre_categoria");
				BigDecimal costeProducto = rs.getBigDecimal("coste");
				BigDecimal precioProducto = rs.getBigDecimal("precio");
				
				boolean tieneIva = rs.getBoolean("tiene_iva");
				int codigoCategoria = rs.getInt("codigo_cat");
				int stock = rs.getInt("stock");
				
				UnidadesDeMedida udm = new UnidadesDeMedida();
				udm.setNombre(nombreUnidadMedida);
				udm.setDescripcion(descripcionUnidadMedida);
				
				categorias cat = new categorias();
				cat.setCodigo(codigoCategoria);
				cat.setNombre(nombreCategoria);
				
				prod=new Productos();
				prod.setNombre(nombreProducto);
				prod.setCodigo(codigoProducto);
				prod.setUdm(udm);
				prod.setPrecioVenta(precioProducto);
				prod.setTieneIva(tieneIva);
				prod.setCoste(costeProducto);
				prod.setCategoria(cat);
				prod.setStock(stock);
				
				productos.add(prod);
			}
		} catch (KrakedevException e) {
			e.printStackTrace();
			throw e;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al consultar productos");
		}
		return productos;
	}
	
	public void crearProd(Productos pr) throws KrakedevException {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con = ConexionBDD.obtenerCone();
			ps=con.prepareStatement("INSERT INTO productos (codigop, nombre_producto, codigo_udm, precio, tiene_iva, coste, codigo_cat, stock) VALUES "
					+ "( ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, pr.getCodigo());
			ps.setString(2, pr.getNombre());
			ps.setString(3, pr.getUdm().getNombre());
			ps.setBigDecimal(4, pr.getPrecioVenta());
			ps.setBoolean(5, pr.getTieneIva());
			ps.setBigDecimal(6, pr.getCoste());
			ps.setInt(7, pr.getCategoria().getCodigo());
			ps.setInt(8, pr.getStock());
			ps.executeUpdate();
			
		}catch(KrakedevException e){
			e.printStackTrace();
			throw e;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al crear el producto");
		}
	}
	
}
