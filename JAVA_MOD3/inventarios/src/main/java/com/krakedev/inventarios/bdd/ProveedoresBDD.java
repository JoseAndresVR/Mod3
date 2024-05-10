package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.excepciones.KrakedevException;
import com.krakedev.inventarios.utils.ConexionBDD;
import com.krakedev.inventrarios.entidades.Proveedores;
import com.krakedev.inventrarios.entidades.tipoDocumentos;

public class ProveedoresBDD {
	
	public ArrayList<Proveedores> buscar(String subcadena) throws KrakedevException{
		ArrayList<Proveedores> proveedor = new ArrayList<Proveedores>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Proveedores prov=null;
		try {
			con = ConexionBDD.obtenerCone();
			ps=con.prepareStatement("select prov.identificador,prov.tipo_doc,td.descripcion,prov.nombre,prov.telefono,prov.correo,prov.direccion from proveedores prov,tipo_documento td"+
					" where prov.tipo_doc = td.codigotp and upper(nombre) like ?");
			ps.setString(1, "%"+subcadena.toUpperCase()+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				String ctd = rs.getString("tipo_doc");
				String nm = rs.getString("nombre");
				String cr = rs.getString("correo");
				String dr = rs.getString("direccion");
				int id=rs.getInt("identificador");
				int tl=rs.getInt("telefono");
				String dc = rs.getString("descripcion");
				tipoDocumentos td = new tipoDocumentos(ctd,dc);
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
	
	public void crearP(Proveedores pv) throws KrakedevException {
		Connection con=null;
		PreparedStatement ps=null;

		try {
			con = ConexionBDD.obtenerCone();
			ps=con.prepareStatement("INSERT INTO proveedores (identificador, tipo_doc, nombre, telefono, correo, direccion) VALUES"
					+ "    (?, ?, ?, ?, ?, ?)");
			ps.setInt(1, pv.getInd());
			ps.setString(2, pv.getTipoD().getCodigo());
			ps.setString(3, pv.getNombre());
			ps.setInt(4, pv.getTelefono());
			ps.setString(5, pv.getCorreo());
			ps.setString(6, pv.getDireccion());
			ps.executeUpdate();
			
		}catch(KrakedevException e){
			e.printStackTrace();
			throw e;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al crear el proveedor");
		}

	}
	
	public ArrayList<Proveedores> buscarPP(String subcadena) throws KrakedevException{
		ArrayList<Proveedores> proveedor = new ArrayList<Proveedores>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Proveedores prov=null;
		try {
			con = ConexionBDD.obtenerCone();
			ps=con.prepareStatement("select prov.identificador,prov.tipo_doc,td.descripcion,prov.nombre,prov.telefono,prov.correo,prov.direccion from proveedores prov,tipo_documento td"+
					" where prov.tipo_doc = td.codigotp and upper(nombre) like ?");
			ps.setString(1, "%"+subcadena.toUpperCase()+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				String ctd = rs.getString("tipo_doc");
				String nm = rs.getString("nombre");
				String cr = rs.getString("correo");
				String dr = rs.getString("direccion");
				int id=rs.getInt("identificador");
				int tl=rs.getInt("telefono");
				String dc = rs.getString("descripcion");
				tipoDocumentos td = new tipoDocumentos(ctd,dc);
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
	
	public Proveedores buscarProveedorPorId(int inde) throws KrakedevException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Proveedores proveedor=null;
		try {
			con = ConexionBDD.obtenerCone();
			ps = con.prepareStatement("select * from proveedores where identificador=?");
			ps.setInt(1, inde);
			rs=ps.executeQuery();
			if(rs.next()) {
				int id=rs.getInt("identificador"),telefono=rs.getInt("telefono");
				tipoDocumentos tp = new tipoDocumentos();
				tp.setCodigo(rs.getString("tipo_doc"));
				String nombre = rs.getString("nombre"),correo=rs.getString("correo"),direccion=rs.getString("direccion");
				proveedor = new Proveedores();
				proveedor.setCorreo(correo);
				proveedor.setDireccion(direccion);
				proveedor.setTipoD(tp);
				proveedor.setNombre(nombre);
				proveedor.setTelefono(telefono);
				proveedor.setInd(id);
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
