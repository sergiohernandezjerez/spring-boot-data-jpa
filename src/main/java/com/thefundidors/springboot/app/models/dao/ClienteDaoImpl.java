package com.thefundidors.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thefundidors.springboot.app.models.entity.Cliente;

@Repository("clienteDaoJPA")
public class ClienteDaoImpl implements IClienteDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() {
		return entityManager.createQuery("from Cliente").getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		return entityManager.find(Cliente.class, id);
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		if (cliente.getId() != null && cliente.getId() > 0) {
			entityManager.merge(cliente);
		} else {
			entityManager.persist(cliente);
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
		entityManager.remove(findOne(id));

	}

}
