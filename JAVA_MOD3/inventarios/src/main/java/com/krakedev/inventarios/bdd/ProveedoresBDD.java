package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.excepciones.KrakedevException;
import com.krakedev.inventarios.utils.ConexionBDD;
import com.krakedev.inventrarios.entidades.Proveedores;

public class ProveedoresBDD {
	
	public static ArrayList<Proveedores> buscar(String subcadena) throws KrakedevException{
		ArrayList<Proveedores> proveedor = new ArrayList<Proveedores>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Proveedores prov=null;
		try {
			con = ConexionBDD.obtenerCone();
			ps=con.prepareStatement("select * from proveedores where upper(nombre) like '%1'");
			ps.setString(1, subcadena.toUpperCase());
			rs=ps.executeQuery();
			while(rs.next()) {
				String td = rs.getString("tipo_doc"),nm = rs.getString("nombre"),cr = rs.getString("correo"),dr = rs.getString("direccion");
				int id=rs.getInt("identificador"),tl=rs.getInt("telefono");
				prov=new Proveedores(id,tl,td,nm,cr,dr);
				proveedor.add(prov);
			}
		} catch (KrakedevException e) {
			e.printStackTrace();
			throw e;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al consultar");
		}
		return proveedor;
	}
	
	
	
}
