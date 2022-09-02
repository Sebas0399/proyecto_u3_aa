package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class UPCParalelo extends Thread {
private PoliciaParalelo policia;

public UPCParalelo(PoliciaParalelo policia) {
	super();
	this.policia = policia;
}

@Override
public void run() {
	// TODO Auto-generated method stub
	this.procesar(policia);
	super.run();
}
public void procesar(PoliciaParalelo policia) {
	long tiempoInicial = System.currentTimeMillis();
	System.out.println("Nombre  hilo procesar:" + Thread.currentThread().getName());
	System.out.println("Capturnado policia : " + policia.getNombre());
	policia.getCriminales().forEach((nombre,peligrosidad)->{
		if(peligrosidad<5) {
			capturar(nombre,peligrosidad);
		}
		else {
			capturarNo(nombre,peligrosidad);
		}
	});

	long tiempoFinal = System.currentTimeMillis();
	long tiempoTrans = (tiempoFinal - tiempoInicial) / 1000;



	System.out.println("termino: "+policia.getNombre()+" en "+tiempoTrans+" seg");
}

public void capturar(String criminal,Integer peligrosidad) {
	System.out.println("Capturando a:" + criminal+" de peligrosidad :"+peligrosidad);
	//
	try {
		TimeUnit.SECONDS.sleep(5);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
public void capturarNo(String criminal,Integer peligrosidad) {
	System.out.println("No se ha capturando a:" + criminal+" de peligrosidad :"+peligrosidad);
	//
	try {
		TimeUnit.SECONDS.sleep(5);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
