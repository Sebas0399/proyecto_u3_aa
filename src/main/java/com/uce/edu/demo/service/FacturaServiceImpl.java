package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService{
@Autowired
private IFacturaRepository facturaRepo;

@Override
public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
	// TODO Auto-generated method stub
	return this.facturaRepo.buscarFacturaInnerJoin(cantidad);
}

@Override
public List<Factura> buscarFacturaOuterJoinRigth(Integer cantidad) {
	// TODO Auto-generated method stub
	return this.facturaRepo.buscarFacturaOuterJoinRigth(cantidad);
}

@Override
public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad) {
	// TODO Auto-generated method stub
	return this.facturaRepo.buscarFacturaOuterJoinLeft(cantidad);
}

@Override
public List<Factura> buscarFacturaWhere(BigDecimal subtotal) {
	// TODO Auto-generated method stub
	return this.facturaRepo.buscarFacturaWhere(subtotal);
}

@Override
public List<Factura> buscarFacturaFetch(BigDecimal subtotal) {
	// TODO Auto-generated method stub
	return this.facturaRepo.buscarFacturaFetch(subtotal);
}

	}

