package com.practica.dev.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.practica.dev.model.Pedido;

@Repository
public interface IPedidoRepository extends IBaseRepository<Pedido, Integer>{
	
	public List<Pedido> findByEstatusPedido( String estatus);

}