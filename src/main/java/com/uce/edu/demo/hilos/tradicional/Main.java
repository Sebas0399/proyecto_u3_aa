package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial=System.currentTimeMillis();
		Cajero cajero1=new Cajero("Antony",Arrays.asList("Daniela","Andrea","Roberto","Pedro"));
		Cajero cajero2=new Cajero("Juan",Arrays.asList("Daniela2","Andrea2","Roberto2"));
		Cajero cajero3=new Cajero("Josue",Arrays.asList("Daniela3","Andrea3"));
		
		PCCajero gestorAtencion=new PCCajero();
		gestorAtencion.procesar(cajero1);
		gestorAtencion.procesar(cajero2);
		gestorAtencion.procesar(cajero3);
		long tiempoFinal=System.currentTimeMillis();
		
		long tiempoEjecucion=(tiempoFinal-tiempoInicial)/1000;
		System.out.println(tiempoEjecucion+" segundos");

	}

}
