package com.krakedev.inventrarios.entidades;

public class categoriasUnidadMedida {
	private String codigo,nombre;

	
	
	public categoriasUnidadMedida() {
		super();
	}

	public categoriasUnidadMedida(String codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}



	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Categorias Unidad de Medida [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
	
	
}
