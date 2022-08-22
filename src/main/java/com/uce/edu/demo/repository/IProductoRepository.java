package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoRepository {
	public Producto buscar(String codigo);
	public void actualizar(Producto p);
}
