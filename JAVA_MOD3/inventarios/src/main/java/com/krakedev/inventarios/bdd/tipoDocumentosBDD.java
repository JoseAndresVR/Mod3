package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.excepciones.KrakedevException;
import com.krakedev.inventarios.utils.ConexionBDD;
import com.krakedev.inventrarios.entidades.tipoDocumentos;

public class tipoDocumentosBDD {
	public ArrayList<tipoDocumentos> recuperar() throws KrakedevException{
		ArrayList<tipoDocumentos> tipoD = new ArrayList<tipoDocumentos>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		tipoDocumentos td=null;
		try {
			con = ConexionBDD.obtenerCone();
			ps=con.prepareStatement("select * from tipo_documento");
			rs=ps.executeQuery();
			while(rs.next()) {
				String cd = rs.getString("codigo");
				String ds = rs.getString("descripcion");
				td=new tipoDocumentos(cd,ds);
				tipoD.add(td);
			}
		} catch (KrakedevException e) {
			e.printStackTrace();
			throw e;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al consultar tipo de documentos");
	}
	return tipoD;
	}
}
