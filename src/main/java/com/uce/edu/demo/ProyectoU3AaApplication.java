package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3AaApplication implements CommandLineRunner {
	@Autowired
	private ITransferenciaService transferenciaService;
	private static Logger LOG = LogManager.getLogger(ProyectoU3AaApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3AaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		//Join
//		List<Factura>listaFacturas=this.facturaService.buscarFacturaFetch(new BigDecimal(11));
//		for(Factura f: listaFacturas) {
//			LOG.info(f);
//		}
//		//Outer Left
//		List<Factura>listaFacturas2=this.facturaService.buscarFacturaWhere(new BigDecimal(11));
//		for(Factura f: listaFacturas2) {
//			LOG.info(f);
//		}
//		
//		

		this.transferenciaService.realizarTransferencia("ASD-120015", "ASD-120016", new BigDecimal(1));
	}

}
