package com.practica.dev.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.practica.dev.dto.RespuestaDTO;
import com.practica.dev.model.Base;

public interface IBaseService <E extends Base, ID extends Serializable>{
	
	public List<E> getAll() throws Exception;
	public Optional<E> getOne(ID id) throws Exception;
	public E update(ID id, E e) throws Exception;
	public E save(E e) throws Exception;
	public boolean delete(ID id) throws Exception;
	

	public RespuestaDTO<E> saveE(E e) throws Exception;
	public RespuestaDTO<List<E>> getAllE() throws Exception;
	public RespuestaDTO<Optional<E>> obtenerPost( @PathVariable ID id) throws Exception;
}
