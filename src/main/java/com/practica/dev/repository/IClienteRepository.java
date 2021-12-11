package com.practica.dev.repository;

import org.springframework.stereotype.Repository;

import com.practica.dev.model.Cliente;

@Repository
public interface IClienteRepository extends IBaseRepository<Cliente, Integer> {

}
