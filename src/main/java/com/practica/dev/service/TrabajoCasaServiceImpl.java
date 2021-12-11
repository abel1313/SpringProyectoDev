package com.practica.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.dev.model.Producto;
import com.practica.dev.model.TrabajoCasa;
import com.practica.dev.repository.IBaseRepository;

@Service
public class TrabajoCasaServiceImpl extends BaseServiceImpl<TrabajoCasa, Integer>
implements ITrabajoCasaService{
	@Autowired
	private ITrabajoCasaService iTrabajoCasaService;
	

	public TrabajoCasaServiceImpl(IBaseRepository<TrabajoCasa, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}
	

}
