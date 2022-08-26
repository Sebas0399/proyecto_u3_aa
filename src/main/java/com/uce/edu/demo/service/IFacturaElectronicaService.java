package com.uce.edu.demo.service;

import java.math.BigDecimal;

public interface IFacturaElectronicaService {
	public void facturarElectronicamente(String nroFactura,Integer nroItems,BigDecimal monto);
}
