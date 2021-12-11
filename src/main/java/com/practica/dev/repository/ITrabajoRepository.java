package com.practica.dev.repository;

import org.springframework.stereotype.Repository;

import com.practica.dev.model.Producto;
import com.practica.dev.model.Trabajo;

@Repository
public interface ITrabajoRepository extends IBaseRepository<Trabajo, Integer> {

}
