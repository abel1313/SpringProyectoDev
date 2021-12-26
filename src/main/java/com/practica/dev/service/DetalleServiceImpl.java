package com.practica.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.dev.model.DetalleVenta;
import com.practica.dev.model.Direccion;
import com.practica.dev.repository.IBaseRepository;
import com.practica.dev.repository.IDetalleRepository;

@Service
public class DetalleServiceImpl extends BaseServiceImpl<DetalleVenta, Integer>implements IDetalleService
{

	@Autowired
	private IDetalleRepository iDetalleRepository;
	
	public DetalleServiceImpl(IBaseRepository<DetalleVenta, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

}
