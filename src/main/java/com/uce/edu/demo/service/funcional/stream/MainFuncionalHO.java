package com.uce.edu.demo.service.funcional.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainFuncionalHO {
	private static Logger LOG = LogManager.getLogger(MainFuncionalHO.class.getName());
	public static void impresion(String cadena) {
		LOG.info("Impresion: "+cadena);
	}
	public static void main(String[] args) {
//suplier
		LOG.info("Supplier HO:");
		Stream<String>SupplierHo=Stream.generate(()->"Supplier Stream HO").limit(7);
		SupplierHo.forEach(cadena->System.out.println(cadena));
		//consumer
		LOG.info("Consumer HO");
		List<String>listaLetras=Arrays.asList("w","b","x","p","c","g","a");
		Stream<String>listaOrdenada=listaLetras.stream().sorted();
		listaOrdenada.forEach((letra)->{
			System.out.println(letra+" letra ordenada");
		});
		//predicate
		LOG.info("Predicate HO");
		List<String>listaLetras1=Arrays.asList("w","b","x","p","c","g","a");
		List<String>listaLetras2=Arrays.asList("w","b","x","p","c","g");
		List<String>listaLetras3=Arrays.asList("w","b","x","p","c");
		List<String>listaLetras4=Arrays.asList("w","b","x","p","c","g","a");
		List<String>listaLetras5=Arrays.asList("w","b","x","p","g","a");
		List<String>listaLetras6=Arrays.asList("w","b","x","p","c","a");
		
		List<List<String>>listafin = new ArrayList<>();
		listafin.add(listaLetras1);
		listafin.add(listaLetras2);
		listafin.add(listaLetras3);
		listafin.add(listaLetras4);
		listafin.add(listaLetras5);
		listafin.add(listaLetras6);

		
		Stream<List<String>>checkListaTamaño=listafin.stream().filter(listaIO->listaIO.size()>5);
		checkListaTamaño.forEach(lista->System.out.println("Filtro: "+lista));
		//funcion
		LOG.info("Function HO");
		Stream<String>listaFun=listaLetras.stream().map(letras->{
			String nuevo=letras.concat("HO");
			
			return nuevo;
		});
		listaFun.forEach(letre->impresion(letre));
		//function unaty operator
	}
}
