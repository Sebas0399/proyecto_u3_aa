package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3AaApplication implements CommandLineRunner{
	@Autowired
	private IHotelService hotelService;
	private static Logger LOG = LogManager.getLogger(ProyectoU3AaApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3AaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Hotel>listaHoteles=this.hotelService.buscarHotelInnerJoin("Familiar");
		for (Hotel h : listaHoteles) {
			LOG.info("Hotel Familiar: " + h.getNombre()+""+h.getDireccion());
		}
		listaHoteles=this.hotelService.buscarHotelOuterJoinLeft("Familiar");
		for (Hotel h : listaHoteles) {
			LOG.info("Hotel Familiar: " + h.getNombre()+""+h.getDireccion());
		}
		listaHoteles=this.hotelService.buscarHotelOuterJoinRigth("Familiar");
		for (Hotel h : listaHoteles) {
			LOG.info("Hotel Familiar: " + h.getNombre()+""+h.getDireccion());
		}
		
		
		
		List<Hotel>listaHoteles2=this.hotelService.buscarHotelInnerJoin();
		for (Hotel h : listaHoteles2) {
			LOG.info("Hotel : " + h.getNombre()+""+h.getDireccion());
		}
		listaHoteles2=this.hotelService.buscarHotelOuterJoinLeft();
		for (Hotel h : listaHoteles2) {
			LOG.info("Hotel : " + h.getNombre()+""+h.getDireccion());
		}
	
	}

}
