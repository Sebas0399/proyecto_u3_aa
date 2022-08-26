package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Producto;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public Producto buscar(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras=:codigo",Producto.class);
		myQuery.setParameter("codigo", codigo);
		return myQuery.getSingleResult();
		
	}

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void actualizar(Producto p) {
		// TODO Auto-generated method stub
		
	}
	
}
