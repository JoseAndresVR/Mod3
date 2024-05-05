package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.tipoDocumentosBDD;
import com.krakedev.inventarios.excepciones.KrakedevException;
import com.krakedev.inventrarios.entidades.tipoDocumentos;
@Path("tiposdocumentos")
public class ServiciosTipoDocumentos {
	@Path("recuperar")
	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response recuperarTd(){
		tipoDocumentosBDD td = new tipoDocumentosBDD();
		ArrayList<tipoDocumentos> tipoD = null;
		try {
			tipoD = td.recuperar();
			return Response.ok(tipoD).build();
		} catch (KrakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
