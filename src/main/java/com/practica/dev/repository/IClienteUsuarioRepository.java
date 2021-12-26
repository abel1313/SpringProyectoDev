package com.practica.dev.repository;

import org.springframework.stereotype.Repository;

import com.practica.dev.model.ClienteUsuario;

@Repository
public interface IClienteUsuarioRepository extends IBaseRepository<ClienteUsuario, Integer>{
	
	
	public ClienteUsuario findByUsuarioId( Integer id) throws Exception;

}
