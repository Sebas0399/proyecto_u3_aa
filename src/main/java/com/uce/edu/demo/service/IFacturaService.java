package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaService {

	public List<Factura>buscarFacturaInnerJoin(Integer cantidad);
	
	public List<Factura>buscarFacturaOuterJoinRigth(Integer cantidad);
	public List<Factura>buscarFacturaOuterJoinLeft(Integer cantidad);
	public List<Factura>buscarFacturaWhere(BigDecimal subtotal);
	public List<Factura>buscarFacturaFetch(BigDecimal subtotal);

}
