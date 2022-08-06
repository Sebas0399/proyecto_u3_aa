package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService{
@Autowired
private IFacturaRepository facturaRepo;
	@Override
	public Factura consultar(Integer id) {
		// TODO Auto-generated method stub
		return this.facturaRepo.consultar(id);
	}

}