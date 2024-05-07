package com.krakedev.inventrarios.entidades;

public class EstadoPedido {
	private String codigo,descripcion;

	
	public EstadoPedido() {
		super();
	}

	public EstadoPedido(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Estado del Pedido [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}
	
	
}
