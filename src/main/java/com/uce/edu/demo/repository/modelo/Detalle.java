package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="detalle")
public class Detalle{
	@Id
	@Column(name ="deta_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deta_id_seq")
	@SequenceGenerator(name = "deta_id_seq", sequenceName = "deta_id_seq", allocationSize = 1)
	
	private Integer id;

	@Column(name="deta_nombre")
	private String nombre;

	@Column(name ="deta_cantidad")
	private Integer cantidad;

	@Column(name ="deta_precio")
	private BigDecimal precio;


	@Column(name ="deta_total")
	private BigDecimal subtotal;
	@ManyToOne
	@JoinColumn(name = "deta_fact_id")
	private Factura factura;
	@ManyToOne
	@JoinColumn(name = "deta_prod_id")
	private Producto producto;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	@Override
	public String toString() {
		return "Detalle [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio
				+ ", subtotal=" + subtotal + ", factura=" + factura + "]";
	}


}

