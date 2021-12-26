package com.practica.dev.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.practica.dev.model.Trabajo;
import com.practica.dev.model.Usuario;

@Repository
public interface IUsuarioRepository extends IBaseRepository<Usuario, Integer>{
	
	
	
	public List<Usuario> findByNombreUsuarioAndContrasenaUsuario(String nombreUsuario, String contrasenaUsuario);
	public List<Usuario> findByNombreUsuario(String nombreUsuario);

}
