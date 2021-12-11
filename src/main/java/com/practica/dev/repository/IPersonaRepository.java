package com.practica.dev.repository;

import org.springframework.stereotype.Repository;
import com.practica.dev.model.Base;
import com.practica.dev.model.Persona;

@Repository
public interface IPersonaRepository extends IBaseRepository<Persona, Integer> {

}
