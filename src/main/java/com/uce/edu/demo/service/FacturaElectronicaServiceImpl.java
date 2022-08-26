package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.modelo.FacturaElectronica;
@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService{
	@Autowired
	private IFacturaElectronicaRepository factElectronicaRepo;
	@Override
	@Transactional(value =TxType.REQUIRES_NEW)
	public void facturarElectronicamente(String nroFactura, Integer nroItems, BigDecimal monto) {
		// TODO Auto-generated method stub
		FacturaElectronica fElectronica=new FacturaElectronica();
		fElectronica.setFechaCreacion(LocalDateTime.now());
		fElectronica.setItems(nroItems);
		fElectronica.setMonto(monto);
		fElectronica.setNumero(nroFactura);
		this.factElectronicaRepo.insertar(fElectronica);
		throw new RuntimeException();
		
	}
	

}
