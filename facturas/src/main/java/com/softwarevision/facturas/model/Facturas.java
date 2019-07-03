package com.softwarevision.facturas.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

@Entity
@Table(name = "detallesdefactura")
public class Facturas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	private String descripcionDelArticulo;
	private String marcaDelArticulo;
	private int cantidad;
	private BigDecimal precioDeCompra;
	private BigDecimal precioDeVenta;
	
	
	// Gets and Sets
	
	
	public String getDescripcionDelArticulo() {
		return descripcionDelArticulo;
	}
	public void setDescripcionDelArticulo(String descripcionDelArticulo) {
		this.descripcionDelArticulo = descripcionDelArticulo;
	}
	public String getMarcaDelArticulo() {
		return marcaDelArticulo;
	}
	public void setMarcaDelArticulo(String marcaDelArticulo) {
		this.marcaDelArticulo = marcaDelArticulo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getPrecioDeCompra() {
		return precioDeCompra;
	}
	public void setPrecioDeCompra(BigDecimal precioDeCompra) {
		this.precioDeCompra = precioDeCompra;
	}
	public BigDecimal getPrecioDeVenta() {
		return precioDeVenta;
	}
	public void setPrecioDeVenta(BigDecimal precioDeVenta) {
		this.precioDeVenta = precioDeVenta;
	}
	
	
	@Override
	public String toString() {
		return "Facturas [id=" + id + ", descripcionDelArticulo=" + descripcionDelArticulo + ", marcaDelArticulo="
				+ marcaDelArticulo + ", cantidad=" + cantidad + ", precioDeCompra=" + precioDeCompra
				+ ", precioDeVenta=" + precioDeVenta + "]";
	}
	

}
