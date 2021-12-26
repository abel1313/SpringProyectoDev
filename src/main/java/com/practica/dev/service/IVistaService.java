package com.practica.dev.service;

import java.util.List;
import java.util.Optional;

import com.practica.dev.dto.RespuestaDTO;
import com.practica.dev.model.Vistas;

public interface IVistaService extends IBaseService<Vistas, Integer>{
	
	public RespuestaDTO<Optional<List<Vistas>>> obtenerVistas() throws Exception;

}
