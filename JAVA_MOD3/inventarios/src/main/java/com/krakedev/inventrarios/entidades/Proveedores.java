package com.krakedev.inventrarios.entidades;



public class Proveedores {
	private int ind,telefono;
	private String tipoD,nombre,correo,direccion;

	public Proveedores() {
		super();
	}
	public Proveedores(int ind, int telefono, String tipoD, String nombre, String correo, String direccion) {
		super();
		this.ind = ind;
		this.telefono = telefono;
		this.tipoD = tipoD;
		this.nombre = nombre;
		this.correo = correo;
		this.direccion = direccion;
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
	public String getTipoD() {
		return tipoD;
	}
	public void setTipoD(String tipoD) {
		this.tipoD = tipoD;
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
	@Override
	public String toString() {
		return "Proveedores [indentificador=" + ind + ", telefono=" + telefono + ", tipo de Documento=" + tipoD + ", nombre=" + nombre
				+ ", correo=" + correo + ", direccion=" + direccion + "]";
	}
	
	
	
	
	
	
}
