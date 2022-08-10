package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;
@Service
public class TransferenciaServiceImpl implements ITransferenciaService {
	@Autowired
	private ICuentaBancariaRepository cuentaRepo;
	@Autowired
	private ITransferenciaRepository transferenciaRepo;
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferencia(String numeroCtaOrigen, String nroCtaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		CuentaBancaria ctaOrigen=this.cuentaRepo.buscar(numeroCtaOrigen);
		BigDecimal saldoOrigen=ctaOrigen.getSaldo();
		BigDecimal saldoFinal=saldoOrigen.min(monto);
		ctaOrigen.setSaldo(saldoFinal);
		this.cuentaRepo.acutalizar(ctaOrigen);
		
		CuentaBancaria ctaDestino=this.cuentaRepo.buscar(nroCtaDestino);
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.cuentaRepo.acutalizar(ctaDestino);
		
		Transferencia t=new Transferencia();
		t.setCuentaDestino(ctaDestino);
		t.setCuentaOrigen(ctaOrigen);
		t.setFecha(LocalDateTime.now());
		t.setMonto(monto);
		
		this.transferenciaRepo.insertar(t);
	}

}
