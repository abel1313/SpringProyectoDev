package com.practica.dev.dto;

import java.util.List;

import com.practica.dev.model.Base;
import com.practica.dev.model.Cliente;
import com.practica.dev.model.Producto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClienteUsuarioDTO extends Base{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private InicioSesionDTO usuario;
	
	private Cliente cliente;
	

}
