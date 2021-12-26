package com.practica.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.dev.model.Persona;
import com.practica.dev.repository.IBaseRepository;
import com.practica.dev.repository.IPersonaRepository;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Integer>
implements IPersonaService
{
	@Autowired
	private IPersonaRepository iPersonaRepository;
	
	public PersonaServiceImpl(IBaseRepository<Persona, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

}
