package com.practica.dev.repository;

import org.springframework.stereotype.Repository;

import com.practica.dev.model.Trabajo;
import com.practica.dev.model.TrabajoCasa;

@Repository
public interface ITrabajoCasaRepository extends IBaseRepository<TrabajoCasa, Integer> {

}
