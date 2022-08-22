package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="factura")
public class Factura {
	@Column(name ="fact_numero")
	private String numero;

	@Column(name="fact_total")
	private BigDecimal total;

	@Column(name="fact_fecha")
	private LocalDateTime fecha;
	@ManyToOne
	@JoinColumn(name = "fact_clie_id")
	private Cliente cliente;

	@OneToMany(mappedBy = "factura",fetch= FetchType.EAGER)
	private List<Detalle> detalles;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Factura [numero=" + numero + ", total=" + total + ", cliente=" + cliente + ", detalles=" + detalles
				+ "]";
	}
	
}
