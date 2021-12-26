package com.practica.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.dev.model.Direccion;
import com.practica.dev.model.Empleado;
import com.practica.dev.repository.IBaseRepository;
import com.practica.dev.repository.IEmpleadoRepository;

@Service
public class EmpleadoServiceImpl extends BaseServiceImpl<Empleado, Integer>implements IEmpleadoService
{

	@Autowired
	private IEmpleadoRepository iEmpleadoRepository;
	public EmpleadoServiceImpl(IBaseRepository<Empleado, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

}
