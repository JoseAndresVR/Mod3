package com.krakedev.inventrarios.entidades;

import java.math.BigDecimal;

public class DetallePedidos {
	private int codigo,cantidadSolicitada,catidadRecibida;
	private BigDecimal subtotal;
	private Productos producto;
	private Pedidos pedido;
	public DetallePedidos() {
		super();
	}
	public DetallePedidos(int codigo, int cantidadSolicitada, int catidadRecibida, BigDecimal subtotal,
			Productos producto, Pedidos pedido) {
		super();
		this.codigo = codigo;
		this.cantidadSolicitada = cantidadSolicitada;
		this.catidadRecibida = catidadRecibida;
		this.subtotal = subtotal;
		this.producto = producto;
		this.pedido = pedido;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCantidadSolicitada() {
		return cantidadSolicitada;
	}
	public void setCantidadSolicitada(int cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}
	public int getCatidadRecibida() {
		return catidadRecibida;
	}
	public void setCatidadRecibida(int catidadRecibida) {
		this.catidadRecibida = catidadRecibida;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public Productos getProducto() {
		return producto;
	}
	public void setProducto(Productos producto) {
		this.producto = producto;
	}
	public Pedidos getPedido() {
		return pedido;
	}
	public void setPedido(Pedidos pedido) {
		this.pedido = pedido;
	}
	@Override
	public String toString() {
		return "DetallePedidos [codigo=" + codigo + ", cantidadSolicitada=" + cantidadSolicitada + ", catidadRecibida="
				+ catidadRecibida + ", subtotal=" + subtotal + ", producto=" + producto + ", pedido=" + pedido + "]";
	}
	
	
}
