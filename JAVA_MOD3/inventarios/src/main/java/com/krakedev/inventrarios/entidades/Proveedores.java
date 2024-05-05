package com.krakedev.inventrarios.entidades;



public class Proveedores {
	private int ind,telefono;
	private String nombre,correo,direccion;
	private tipoDocumentos tipoD;

	public Proveedores() {
		super();
	}

	public Proveedores(int ind, int telefono, tipoDocumentos tipoD, String nombre, String correo, String direccion) {
		super();
		this.ind = ind;
		this.telefono = telefono;
		this.nombre = nombre;
		this.correo = correo;
		this.direccion = direccion;
		this.tipoD = tipoD;
	}

	public int getInd() {
		return ind;
	}

	public void setInd(int ind) {
		this.ind = ind;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public tipoDocumentos getTipoD() {
		return tipoD;
	}

	public void setTipoD(tipoDocumentos tipoD) {
		this.tipoD = tipoD;
	}

	@Override
	public String toString() {
		return "Proveedores [identificador=" + ind + ", telefono=" + telefono + ", nombre=" + nombre + ", correo=" + correo
				+ ", direccion=" + direccion + ", tipo de documento=" + tipoD + "]";
	}
	
	
	
	
	
	
	
}
