package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.CategoriasBDD;
import com.krakedev.inventarios.excepciones.KrakedevException;
import com.krakedev.inventrarios.entidades.categorias;

@Path("categoria")
public class ServicioCategorias {
	@Path("crear")
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response crearProd(categorias categoria) {
		CategoriasBDD cat = new CategoriasBDD();
		try {
			cat.crearCat(categoria);
			return Response.ok().build();
		}  catch (KrakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("actualizar")
	@PUT
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response actualizarProd(categorias categoria) {
		CategoriasBDD cat = new CategoriasBDD();
		try {
			cat.actualizarCat(categoria);
			return Response.ok().build();
		}  catch (KrakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("recuperar")
	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response recuperarProd() {
		CategoriasBDD cat = new CategoriasBDD();
		ArrayList<categorias> categorias = null;
		try {
			categorias = cat.recuperarCat();
			return Response.ok(categorias).build();
		}  catch (KrakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
