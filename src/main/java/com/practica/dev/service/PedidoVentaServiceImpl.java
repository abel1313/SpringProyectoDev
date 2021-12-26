package com.practica.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.dev.model.PedidoVenta;
import com.practica.dev.model.Permisos;
import com.practica.dev.repository.IBaseRepository;
import com.practica.dev.repository.IPedidoVentaRepository;

@Service
public class PedidoVentaServiceImpl extends BaseServiceImpl<PedidoVenta, Integer>
implements IPedidoVenta{

	@Autowired
	private IPedidoVentaRepository  IPedidoVentaRepository;
	public PedidoVentaServiceImpl(IBaseRepository<PedidoVenta, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

}
