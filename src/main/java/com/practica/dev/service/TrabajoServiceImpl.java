package com.practica.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.dev.model.Trabajo;
import com.practica.dev.model.TrabajoCasa;
import com.practica.dev.repository.IBaseRepository;

@Service
public class TrabajoServiceImpl  extends BaseServiceImpl<Trabajo, Integer>
implements ITrabajoService{
	
	@Autowired
	private ITrabajoService iTrabajoService;
	

	public TrabajoServiceImpl(IBaseRepository<Trabajo, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

}
