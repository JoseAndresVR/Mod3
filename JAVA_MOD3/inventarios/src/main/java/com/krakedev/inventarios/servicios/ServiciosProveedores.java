package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.ProveedoresBDD;
import com.krakedev.inventarios.excepciones.KrakedevException;
import com.krakedev.inventrarios.entidades.Proveedores;

@Path("proveedores")
public class ServiciosProveedores {
	@Path("buscar/{subc}")
	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("subc")String subCadena){
		ProveedoresBDD prov = new ProveedoresBDD();
		ArrayList<Proveedores> proveedor = null;
		try {
			proveedor = prov.buscar(subCadena);
			return Response.ok(proveedor).build();
		} catch (KrakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	@Path("crear")
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response crearProv(Proveedores prove) {
		ProveedoresBDD prov = new ProveedoresBDD();
		try {
			prov.crearP(prove);
			return Response.ok().build();
		} catch (KrakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
