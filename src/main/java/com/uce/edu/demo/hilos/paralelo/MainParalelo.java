package com.uce.edu.demo.hilos.paralelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tI = System.currentTimeMillis();

		Map<String, Integer> criminales = new HashMap<String, Integer>();
		for (int i = 0; i <= 10; i++) {
			int min = 1;
			int max = 10;

			Random random = new Random();

			int value = random.nextInt(max + min) + min;

			criminales.put("Chito", value);
		}

		PoliciaParalelo p1 = new PoliciaParalelo("Pedro", criminales);
		PoliciaParalelo p2 = new PoliciaParalelo("Juan", criminales);
		PoliciaParalelo p3 = new PoliciaParalelo("Andres", criminales);
		PoliciaParalelo p4 = new PoliciaParalelo("Maria", criminales);
		PoliciaParalelo p5 = new PoliciaParalelo("Juliana", criminales);

		UPCParalelo upc1 = new UPCParalelo(p1);
		upc1.start();

		UPCParalelo upc2 = new UPCParalelo(p5);
		upc2.start();
		UPCParalelo upc3 = new UPCParalelo(p2);
		upc3.start();
		UPCParalelo upc4 = new UPCParalelo(p3);
		upc4.start();
		UPCParalelo upc5 = new UPCParalelo(p4);
		upc5.start();

		long tF = System.currentTimeMillis();
		long tT = (tF - tI) / 1000;

		System.out.println(tT + "seg");

	}

}
