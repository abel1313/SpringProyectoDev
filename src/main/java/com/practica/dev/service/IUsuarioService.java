package com.practica.dev.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.practica.dev.dto.InicioSesionDTO;
import com.practica.dev.dto.RespuestaDTO;
import com.practica.dev.dto.UsuarioDTO;
import com.practica.dev.model.Trabajo;
import com.practica.dev.model.Usuario;
import com.practica.dev.repository.IUsuarioRepository;

public interface IUsuarioService extends IBaseService<Usuario, Integer> 
{

	public RespuestaDTO<Stream<InicioSesionDTO>> iniciarSesion(@PathVariable String nombreUsuario, @PathVariable String contrasenaUsuario) throws Exception;
	public RespuestaDTO<Boolean> existeUsuario(@PathVariable String nombreUsuario) throws Exception;
	
	public RespuestaDTO<Boolean> registrarUsuario(@RequestBody Usuario usuario) throws Exception;
	
	public RespuestaDTO<List<InicioSesionDTO>> obtenerUsuarioPermisos() throws Exception;


}
