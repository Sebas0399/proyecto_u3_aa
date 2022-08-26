package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

public interface IFacturaService {
	public BigDecimal calcularTotal(Integer id);
	public Integer cantidadTotal(Integer id);
	public BigDecimal facturar(String cedula,String nroFactura,List<String>codBarras);
	
	
}
