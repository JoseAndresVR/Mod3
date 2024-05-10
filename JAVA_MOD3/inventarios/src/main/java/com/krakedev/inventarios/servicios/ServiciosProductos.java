package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.ProductosBDD;
import com.krakedev.inventarios.excepciones.KrakedevException;
import com.krakedev.inventrarios.entidades.Productos;

@Path("productos")
public class ServiciosProductos {
	
	@Path("buscar/{subc}")
	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("subc")String subCadena){
		ProductosBDD prod = new ProductosBDD();
		ArrayList<Productos> productos = null;
		try {
			productos = prod.buscar(subCadena);
			return Response.ok(productos).build();
		} catch (KrakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("crearP")
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response crearP(Productos prod) {
		ProductosBDD producto = new ProductosBDD();
		try {
			producto.crearProd(prod);
			return Response.ok().build();
		} catch (KrakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("actualizar")
	@PUT
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response actualizarP(Productos prod) {
		ProductosBDD producto = new ProductosBDD();
		try {
			producto.actualizarP(prod);
			return Response.ok().build();
		} catch (KrakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("buscarPorId/{idProducto}")
	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response buscarPorId(@PathParam("idProducto")int idProd) {
		ProductosBDD producto = new ProductosBDD();
		Productos prod = null;
		try {
			prod=producto.buscarProductoPorId(idProd);
			return Response.ok(prod).build();
		} catch (KrakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	
	
	
}
