package com.practica.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.dev.model.Cliente;
import com.practica.dev.model.Persona;
import com.practica.dev.repository.IBaseRepository;
import com.practica.dev.repository.IPersonaRepository;

@Service
public class IClienteServiceImpl extends BaseServiceImpl<Cliente, Integer>
implements IClienteService {
	
	@Autowired
	private IPersonaRepository iPeRepository;
	
	
	
	public IClienteServiceImpl(IBaseRepository<Cliente, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}



}
