package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.reactive.TransactionSynchronizationManager;

import com.uce.edu.demo.ProyectoU3AaApplication;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository{
	@PersistenceContext
	private EntityManager entityManager;
	private static Logger LOG = LogManager.getLogger(CuentaBancariaRepositoryImpl.class.getName());

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void acutalizar(CuentaBancaria cuenta) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuenta);
		//throw new RuntimeException();
	}
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public CuentaBancaria buscar(String numero) {
		// TODO Auto-generated method stub
		//LOG.info(TransactionSynchronizationManager.);
		TypedQuery<CuentaBancaria>myQuery=this.entityManager.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero=:numero",CuentaBancaria.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}

}
