package com.thefundidors.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.thefundidors.springboot.app.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{
	
}
