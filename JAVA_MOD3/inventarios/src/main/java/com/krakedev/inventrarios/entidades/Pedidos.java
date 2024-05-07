package com.krakedev.inventrarios.entidades;

import java.util.ArrayList;
import java.util.Date;

public class Pedidos {
	private int numero;
	private Date fecha;
	private EstadoPedido estadoPedido;
	private Proveedores proveedor;
	private ArrayList<DetallePedidos> detallesP;
	
	public Pedidos() {
		super();
	}
	public Pedidos(int numero, Date fecha, EstadoPedido estadoPedido, Proveedores proveedor) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.estadoPedido = estadoPedido;
		this.proveedor = proveedor;
	}
	
	public ArrayList<DetallePedidos> getDetallesP() {
		return detallesP;
	}
	public void setDetallesP(ArrayList<DetallePedidos> detallesP) {
		this.detallesP = detallesP;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public EstadoPedido getEstadoPedido() {
		return estadoPedido;
	}
	public void setEstadoPedido(EstadoPedido estadoPedido) {
		this.estadoPedido = estadoPedido;
	}
	public Proveedores getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedores proveedor) {
		this.proveedor = proveedor;
	}
	@Override
	public String toString() {
		return "Pedidos [Numero=" + numero + ", Fecha=" + fecha + ", Estado Pedido=" + estadoPedido + ", Proveedor="
				+ proveedor + "]";
	}
	
	
}
