package com.krakedev.inventarios.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.VentasBDD;
import com.krakedev.inventarios.excepciones.KrakedevException;
import com.krakedev.inventrarios.entidades.Ventas;

@Path("ventas")
public class ServiciosVenta {
	@Path("guardar")
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response insertarP(Ventas vt) {
		VentasBDD venta = new VentasBDD();
		try {
			venta.insertar(vt);
			return Response.ok().build();
		} catch (KrakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
