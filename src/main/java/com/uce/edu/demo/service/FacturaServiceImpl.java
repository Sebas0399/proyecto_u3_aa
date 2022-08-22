package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.modelo.Detalle;
import com.uce.edu.demo.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService{
	@Autowired
	private IFacturaRepository facturaRepo;
	@Override
	public BigDecimal calcularTotal(Integer id) {
		// TODO Auto-generated method stub
		Factura f=this.facturaRepo.buscar(id);
		List<Detalle> productos=f.getDetalles();
		BigDecimal valorFactura=new BigDecimal(0);
		
		for(Detalle p: productos) {
			BigDecimal cantidad=new BigDecimal(p.getCantidad());
		}
		return valorFactura;
	}
	@Override
	public Integer cantidadTotal(Integer id) {
		// TODO Auto-generated method stub
		Factura f=this.facturaRepo.buscar(id);
		List<Detalle> productos=f.getDetalles();
		Integer totalProductos=0;
		
		for(Detalle p: productos) {
			totalProductos=totalProductos+p.getCantidad();
		}
		
		return totalProductos;
	}

}
