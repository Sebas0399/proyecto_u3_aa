package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaRepository {
public void insertar(Factura factura);
public Factura buscar(Integer id);
}
