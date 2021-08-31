package com.thefundidors.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thefundidors.springboot.app.models.entity.Cliente;

@Repository
public class ClienteDaoImpl implements IClienteDao {
	
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Cliente> findAll() {
		return entityManager.createQuery("from Cliente").getResultList();
	}

}
