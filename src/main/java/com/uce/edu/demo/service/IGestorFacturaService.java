package com.uce.edu.demo.service;

import java.util.List;

public interface IGestorFacturaService {
	public void generarFactura(String cedula,String nroFactura,List<String>codigoBarras);
}
