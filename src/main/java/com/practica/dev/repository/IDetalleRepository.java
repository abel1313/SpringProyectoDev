package com.practica.dev.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practica.dev.model.DetalleVenta;

@Repository
public interface IDetalleRepository extends IBaseRepository<DetalleVenta, Integer>{
	
	public List<DetalleVenta> findByVentaId( Integer idVenta );

}
