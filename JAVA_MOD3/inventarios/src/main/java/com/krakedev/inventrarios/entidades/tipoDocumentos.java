package com.krakedev.inventrarios.entidades;

public class tipoDocumentos {
	private String codigo,descripcion;

	
	public tipoDocumentos() {
		super();
	}

	public tipoDocumentos(String codigo, String descripcion) {
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
		return "Tipo de Documentos [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}
	
	
	
}
