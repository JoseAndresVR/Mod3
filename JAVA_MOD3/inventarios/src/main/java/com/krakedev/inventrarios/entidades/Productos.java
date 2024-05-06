package com.krakedev.inventrarios.entidades;

import java.math.BigDecimal;

public class Productos {
	private String nombre;
	private UnidadesDeMedida udm;
	private BigDecimal precioVenta,coste;
	private boolean tieneIva;
	private categorias categoria;
	private int stock,codigo;
	
	public Productos() {
		super();
	}

	public Productos(int codigo, String nombre, UnidadesDeMedida udm, BigDecimal precioVenta, BigDecimal coste,
			boolean tieneIva, categorias categoria, int stock) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.udm = udm;
		this.precioVenta = precioVenta;
		this.coste = coste;
		this.tieneIva = tieneIva;
		this.categoria = categoria;
		this.stock = stock;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigoProducto) {
		this.codigo = codigoProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public UnidadesDeMedida getUdm() {
		return udm;
	}

	public void setUdm(UnidadesDeMedida udm) {
		this.udm = udm;
	}

	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

	public BigDecimal getCoste() {
		return coste;
	}

	public void setCoste(BigDecimal coste) {
		this.coste = coste;
	}

	public boolean isTieneIva() {
		return tieneIva;
	}

	public void setTieneIva(boolean tieneIva) {
		this.tieneIva = tieneIva;
	}

	public categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(categorias categoria) {
		this.categoria = categoria;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Productos [codigo=" + codigo + ", nombre=" + nombre + ", Unidad De Medida=" + udm + ", Precio Venta=" + precioVenta
				+ ", coste=" + coste + ", Tiene Iva=" + tieneIva + ", categoria=" + categoria + ", stock=" + stock + "]";
	}
	
	



}
