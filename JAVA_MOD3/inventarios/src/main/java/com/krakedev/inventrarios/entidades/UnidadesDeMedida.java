package com.krakedev.inventrarios.entidades;

public class UnidadesDeMedida {
	private String nombre,descripcion;
	private categoriasUnidadMedida catUM;
	public UnidadesDeMedida() {
		super();
	}
	
	
	public UnidadesDeMedida(String nombre, String descripcion, categoriasUnidadMedida catUM) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.catUM = catUM;
	}

	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public categoriasUnidadMedida getCatUM() {
		return catUM;
	}
	public void setCatUM(categoriasUnidadMedida catUM) {
		this.catUM = catUM;
	}
	@Override
	public String toString() {
		return "Unidades de Medida [Codigo=" + nombre + ", Descripcion=" + descripcion + ", Categoria Unidades de Medida=" + catUM + "]";
	}
	
	
}
