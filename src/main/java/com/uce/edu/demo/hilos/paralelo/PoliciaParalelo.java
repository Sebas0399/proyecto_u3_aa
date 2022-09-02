package com.uce.edu.demo.hilos.paralelo;

import java.util.List;
import java.util.Map;

public class PoliciaParalelo {
	String nombre;
	Map<String,Integer>criminales;
	
	public PoliciaParalelo(String nombre, Map<String, Integer> criminales) {
		super();
		this.nombre = nombre;
		this.criminales = criminales;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Map<String, Integer> getCriminales() {
		return criminales;
	}
	public void setCriminales(Map<String, Integer> criminales) {
		this.criminales = criminales;
	}
	@Override
	public String toString() {
		return "PoliciaParalelo [nombre=" + nombre + ", criminales=" + criminales + "]";
	}
	
}
