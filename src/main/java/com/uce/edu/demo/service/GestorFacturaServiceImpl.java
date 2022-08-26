package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorFacturaServiceImpl implements IGestorFacturaService{
	

	@Autowired
	private IFacturaElectronicaService facturaElectronicaService;

	@Autowired
	private IFacturaService facturaService;

	
	
	@Override
	@Transactional(value =TxType.REQUIRED)
	public void generarFactura(String cedula, String nroFactura, List<String> codigoBarras) {
		// TODO Auto-generated method stub
		
		BigDecimal total=this.facturaService.facturar(cedula, nroFactura, codigoBarras);
		this.facturaElectronicaService.facturarElectronicamente(nroFactura, codigoBarras.size(), total);
		}
	}


