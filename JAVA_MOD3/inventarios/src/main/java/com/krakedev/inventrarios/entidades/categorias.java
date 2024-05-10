package com.krakedev.inventrarios.entidades;

public class categorias {

	private String nombre;
	private int codigo,categoria_padre;
	
	public categorias() {
		super();
	}

	public categorias(int codigo, String nombre, int categoria_padre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.categoria_padre = categoria_padre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigoCategoria) {
		this.codigo = codigoCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCategoria_padre() {
		return categoria_padre;
	}

	public void setCategoria_padre(int categoria_padre) {
		this.categoria_padre = categoria_padre;
	}

	@Override
	public String toString() {
		return "categorias [codigo=" + codigo + ", nombre=" + nombre + ", categoria_padre=" + categoria_padre + "]";
	}
	
	
	
	
	
	
}
