package com.practica.dev.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.practica.dev.dto.MostrarClienteDTO;
import com.practica.dev.dto.RespuestaDTO;
import com.practica.dev.model.Cliente;

public interface IClienteService extends IBaseService<Cliente, Integer> {
	
	
	public RespuestaDTO<Stream<MostrarClienteDTO>> obtenerClientes() throws Exception;

}
