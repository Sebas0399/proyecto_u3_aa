package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tI = System.currentTimeMillis();
		CajeroParalelo c1=new CajeroParalelo("Antony", Arrays.asList("Jose"));
		CajeroParalelo c2=new CajeroParalelo("Johan", Arrays.asList("Jose2"));
		CajeroParalelo c3=new CajeroParalelo("Marco", Arrays.asList("Jose3"));
		
		CajeroParalelo c4=new CajeroParalelo("Antony", Arrays.asList("Pepe"));
		CajeroParalelo c5=new CajeroParalelo("Johan", Arrays.asList("Pepe2"));
		CajeroParalelo c6=new CajeroParalelo("Marco", Arrays.asList("Pepe3"));
		
		//Antony
		PCCajeroParalelo gestorAtencion = new PCCajeroParalelo(c1);
		gestorAtencion.start();
		// Johan
		PCCajeroParalelo gestorAtencion2 = new PCCajeroParalelo(c2);
		gestorAtencion2.start();
		// Marco
		PCCajeroParalelo gestorAtencion3 = new PCCajeroParalelo(c3);
		gestorAtencion3.start();


		//Antony
		PCCajeroParalelo gestorAtencion4 = new PCCajeroParalelo(c4);
		gestorAtencion4.start();
		// Johan
		PCCajeroParalelo gestorAtencion5 = new PCCajeroParalelo(c5);
		gestorAtencion5.start();
		// Marco
		PCCajeroParalelo gestorAtencion6 = new PCCajeroParalelo(c6);
		gestorAtencion6.start();
		
		long tF = System.currentTimeMillis();
		long tT = (tF - tI) / 1000;

		System.out.println(tT + "seg");

		
	}

}
