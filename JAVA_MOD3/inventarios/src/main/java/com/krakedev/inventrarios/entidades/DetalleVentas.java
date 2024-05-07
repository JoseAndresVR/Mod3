package com.krakedev.inventrarios.entidades;

import java.math.BigDecimal;

public class DetalleVentas {
	private int codigo,cantidad;
	private BigDecimal subtotalSinIva,subtotalConIva,precio;
	private Productos producto;
	private Ventas ventas;
	public DetalleVentas() {
		super();
	}
	
	

	public DetalleVentas(int codigo, int cantidad, BigDecimal subtotalSinIva, BigDecimal subtotalConIva,
			BigDecimal precio, Productos producto, Ventas ventas) {
		super();
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.subtotalSinIva = subtotalSinIva;
		this.subtotalConIva = subtotalConIva;
		this.precio = precio;
		this.producto = producto;
		this.ventas = ventas;
	}



	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getSubtotalSinIva() {
		return subtotalSinIva;
	}

	public void setSubtotalSinIva(BigDecimal subtotalSinIva) {
		this.subtotalSinIva = subtotalSinIva;
	}

	public BigDecimal getSubtotalConIva() {
		return subtotalConIva;
	}

	public void setSubtotalConIva(BigDecimal subtotalConIva) {
		this.subtotalConIva = subtotalConIva;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	public Ventas getVentas() {
		return ventas;
	}

	public void setVentas(Ventas ventas) {
		this.ventas = ventas;
	}



	public BigDecimal getPrecio() {
		return precio;
	}



	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}



	@Override
	public String toString() {
		return "DetalleVentas [codigo=" + codigo + ", cantidad=" + cantidad + ", subtotalSinIva=" + subtotalSinIva
				+ ", subtotalConIva=" + subtotalConIva + ", precio=" + precio + ", producto=" + producto + ", ventas="
				+ ventas + "]";
	}

	
	
}
