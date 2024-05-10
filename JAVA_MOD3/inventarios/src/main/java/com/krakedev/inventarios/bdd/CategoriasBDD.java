package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.excepciones.KrakedevException;
import com.krakedev.inventarios.utils.ConexionBDD;
import com.krakedev.inventrarios.entidades.categorias;

public class CategoriasBDD {
	
	/*CREAR CATEGORIA*/
	public void crearCat(categorias ct) throws KrakedevException {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con = ConexionBDD.obtenerCone();
			ps=con.prepareStatement("INSERT INTO categorias (codigoca, nombre_categoria, categoria_padre) VALUES"
					+ "(?, ?, ?)");
			ps.setInt(1, ct.getCodigo());
			ps.setString(2, ct.getNombre());
			ps.setInt(3, 0);
			ps.executeUpdate();
			
		}catch(KrakedevException e){
			e.printStackTrace();
			throw e;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al crear la categoria");
		}
	}
	
	
	/*ACTUALIZAR CATEGORIA*/
	public void actualizarCat(categorias ct) throws KrakedevException {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con = ConexionBDD.obtenerCone();
			ps=con.prepareStatement("UPDATE categorias set nombre_categoria=?, categoria_padre=? where codigoca=? ");
			ps.setString(1, ct.getNombre());
			ps.setInt(2, ct.getCategoria_padre());
			ps.setInt(3, ct.getCodigo());
			ps.executeUpdate();
			
		}catch(KrakedevException e){
			e.printStackTrace();
			throw e;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al actualizar la categoria");
		}
	}
	
	/*RECUPERAR TODO*/
	
	public ArrayList<categorias> recuperarCat() throws KrakedevException {
		Connection con=null;
		PreparedStatement ps=null;
		ArrayList<categorias> categorias = new ArrayList<categorias>();
		categorias cat = null;
		ResultSet rs = null;
		try {
			con = ConexionBDD.obtenerCone();
			ps=con.prepareStatement("select * from categorias");
			rs=ps.executeQuery();
			while(rs.next()) {
				int cod = rs.getInt("codigoca");
				String nm = rs.getString("nombre_categoria");
				int cp = rs.getInt("categoria_padre");
				cat = new categorias(cod,nm,cp);
				categorias.add(cat);
			}
			
		}catch(KrakedevException e){
			e.printStackTrace();
			throw e;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al recuperar las categorias");
		}
		return categorias;
	}
	
	
	
	
	
}
