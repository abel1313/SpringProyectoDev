package com.practica.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.dev.model.Direccion;
import com.practica.dev.repository.IBaseRepository;
import com.practica.dev.repository.IDireccionReporitory;

@Service
public class DireccionServiceImpl extends BaseServiceImpl<Direccion, Integer>implements IDireccioneService
{
	@Autowired
	private IDireccionReporitory iDireccionReporitory;
	public DireccionServiceImpl(IBaseRepository<Direccion, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

}
