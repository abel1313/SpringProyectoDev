package com.practica.dev.dto;

import java.util.List;

import com.practica.dev.model.Permisos;

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
public class InicioSesionDTO {
	
	private Integer id;
	private String nombreUsuario;
	private List<Permisos> permisos;

}
