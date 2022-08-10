package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {
	public void acutalizar(CuentaBancaria cuenta);
	public CuentaBancaria buscar(String numero);
}
