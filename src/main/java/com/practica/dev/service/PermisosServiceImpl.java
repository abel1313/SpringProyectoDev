package com.practica.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.dev.model.Permisos;
import com.practica.dev.model.Persona;
import com.practica.dev.repository.IBaseRepository;
import com.practica.dev.repository.IPermisoRepository;

@Service
public class PermisosServiceImpl extends BaseServiceImpl<Permisos, Integer>
implements IPermisosService{
	
	@Autowired
	private IPermisoRepository iPermisoRepository;

	public PermisosServiceImpl(IBaseRepository<Permisos, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

}
