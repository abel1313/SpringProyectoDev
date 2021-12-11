package com.practica.dev.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.practica.dev.model.Base;
import com.practica.dev.model.Persona;
import com.practica.dev.repository.IBaseRepository;

public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements IBaseService<E, ID> {

	protected IBaseRepository<E, ID> iBaseRepository;
	
	public BaseServiceImpl( IBaseRepository<E, ID> iBaseRepository )
	{
			this.iBaseRepository = iBaseRepository;
	}

	@Override
	public List<E> getAll() throws Exception{
		// TODO Auto-generated method stub
		try {
			return this.iBaseRepository.findAll();
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public E update(ID id, E e) throws Exception {
		// TODO Auto-generated method stub
		try {
			Optional<E> lista = this.iBaseRepository.findById(id);
			E entityUpdate = lista.get();
			entityUpdate = this.iBaseRepository.save(entityUpdate);
			return entityUpdate;
		}catch(Exception exception)
		{
			throw new Exception(exception.getMessage());
		}
	}
	@Override
	public E save(E e) throws Exception {
		// TODO Auto-generated method stub
		try {
			return this.iBaseRepository.save(e);
		}catch(Exception exception)
		{
			throw new Exception(exception.getMessage());
		}
	}

	@Override
	public boolean delete(ID id) throws Exception {
		// TODO Auto-generated method stub
		try {
			if( this.iBaseRepository.existsById(id))
			{
				this.iBaseRepository.deleteById(id);
				return true;
			}else
			{
				return false;
			}
			
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	
	
	
}
