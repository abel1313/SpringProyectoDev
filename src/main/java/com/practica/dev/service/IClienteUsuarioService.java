package com.practica.dev.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.practica.dev.dto.ClienteUsuarioDTO;
import com.practica.dev.dto.RespuestaDTO;
import com.practica.dev.model.ClienteUsuario;
import com.practica.dev.model.Usuario;

public interface IClienteUsuarioService extends IBaseService<ClienteUsuario, Integer>{
	
	public RespuestaDTO<ClienteUsuarioDTO> obtenerUsuarioId(@RequestBody Usuario usuario) throws Exception;
	
	public RespuestaDTO<ClienteUsuarioDTO> buscarDatosId(@PathVariable Integer id) throws Exception;

}
