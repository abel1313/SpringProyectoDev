package com.practica.dev.repository;

import org.springframework.stereotype.Repository;
import com.practica.dev.model.Producto;


@Repository
public interface IProductoRepository extends IBaseRepository<Producto, Integer> {

}
