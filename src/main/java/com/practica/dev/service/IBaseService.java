package com.practica.dev.service;

import java.io.Serializable;
import java.util.List;

import com.practica.dev.model.Base;

public interface IBaseService <E extends Base, ID extends Serializable>{
	
	public List<E> getAll() throws Exception;
	public E update(ID id, E e) throws Exception;
	public E save(E e) throws Exception;
	public boolean delete(ID id) throws Exception;
}
