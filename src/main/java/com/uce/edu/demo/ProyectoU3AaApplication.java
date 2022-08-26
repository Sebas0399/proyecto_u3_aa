package com.uce.edu.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IGestorFacturaService;


@SpringBootApplication
public class ProyectoU3AaApplication implements CommandLineRunner {
	
	private static Logger LOG = LogManager.getLogger(ProyectoU3AaApplication.class.getName());
@Autowired
private IGestorFacturaService facturaService;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3AaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<String> codBarras=new ArrayList<>();
		codBarras.add("PC-145");
		codBarras.add("QW-587");
		this.facturaService.generarFactura("1725776650", "1", codBarras);
		}

}
