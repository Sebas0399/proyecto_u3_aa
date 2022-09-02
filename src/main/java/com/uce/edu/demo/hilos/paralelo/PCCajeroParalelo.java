package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class PCCajeroParalelo extends Thread {
	private CajeroParalelo cajeroParalelo;

	public PCCajeroParalelo(CajeroParalelo cajeroParalelo) {
		super();
		this.cajeroParalelo = cajeroParalelo;
	}

//metodo a paralelizar
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.procesar(cajeroParalelo);
	}

	public void procesar(CajeroParalelo cajeroParalelo) {
		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre  hilo procesar:" + Thread.currentThread().getName());
		System.out.println("Procesando cajero: " + cajeroParalelo.getNombre());
		for (String cliente : cajeroParalelo.getClientes()) {
			this.atenderCliente(cliente);
		}
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTrans = (tiempoFinal - tiempoInicial) / 1000;



		System.out.println("termino: "+cajeroParalelo.getNombre()+" en "+tiempoTrans+" seg");
	}

	public void atenderCliente(String cliente) {
		System.out.println("Atendiendo: a:" + cliente);
		//
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
