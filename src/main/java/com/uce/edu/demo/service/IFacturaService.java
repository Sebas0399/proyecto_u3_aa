package com.uce.edu.demo.service;

import java.math.BigDecimal;

public interface IFacturaService {
	public BigDecimal calcularTotal(Integer id);
	public Integer cantidadTotal(Integer id);
	
	
}
