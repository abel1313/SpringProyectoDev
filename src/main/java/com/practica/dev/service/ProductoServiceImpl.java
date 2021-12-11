package com.practica.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.dev.model.Producto;
import com.practica.dev.repository.IBaseRepository;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Integer>
implements IProductoService{

	@Autowired
	private IProductoService iProductoService;
	
	
	public ProductoServiceImpl(IBaseRepository<Producto, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

}
