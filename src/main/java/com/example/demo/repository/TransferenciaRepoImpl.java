package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional

public class TransferenciaRepoImpl implements ITransferenciaRepo {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(transferencia);
	}

	@Override
	public List<Transferencia> seleccionarTodo() {
		// TODO Auto-generated method stub
		String jpql="SELECT t FROM Transferencia t";
		TypedQuery<Transferencia> myQuery=this.entityManager.createQuery(jpql,Transferencia.class);
		
		return myQuery.getResultList();
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(transferencia);
	}

}
