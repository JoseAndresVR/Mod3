package com.krakedev.inventrarios.entidades;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class Ventas {
	private int codigo;
	private Date fecha;
	private BigDecimal totalSinIva,total;
	private ArrayList<DetalleVentas> detalleVenta;
	
	public Ventas() {
		super();
	}
	
	public Ventas(int codigo, Date fecha, BigDecimal totalSinIva, BigDecimal total) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.totalSinIva = totalSinIva;
		this.total = total;
	}

	public ArrayList<DetalleVentas> getDetalleVenta() {
		return detalleVenta;
	}

	public void setDetalleVenta(ArrayList<DetalleVentas> detalleVenta) {
		this.detalleVenta = detalleVenta;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getTotalSinIva() {
		return totalSinIva;
	}
	public void setTotalSinIva(BigDecimal totalSinIva) {
		this.totalSinIva = totalSinIva;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Ventas [codigo=" + codigo + ", fecha=" + fecha + ", totalSinIva=" + totalSinIva + ", total=" + total
				+ "]";
	}
	
	
	
}
