package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Factura;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(
				"Select f FROM Factura f INNER JOIN f.detalles de WHERE de.cantidad=:cantidad"
				,Factura.class);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinRigth(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(
				"Select f FROM Factura f RIGHT JOIN f.detalles de WHERE de.cantidad=:cantidad"
				,Factura.class);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery=this.entityManager.createQuery(
				"Select f FROM Factura f LEFT JOIN f.detalles de WHERE de.cantidad=:cantidad"
				,Factura.class);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getResultList();
	}

	

	
}
