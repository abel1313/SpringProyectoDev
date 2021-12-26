package com.practica.dev.repository;

import org.springframework.stereotype.Repository;

import com.practica.dev.model.Permisos;
import com.practica.dev.model.Persona;

@Repository
public interface IPermisoRepository extends IBaseRepository<Permisos, Integer> {

}
