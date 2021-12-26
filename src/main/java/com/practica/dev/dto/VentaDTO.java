package com.practica.dev.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.practica.dev.model.Cliente;
import com.practica.dev.model.DetalleVenta;
import com.practica.dev.model.Producto;
import com.practica.dev.model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.practica.dev.model.Base;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VentaDTO extends Base{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double totalVenta;
	private String fechaVenta;
	private InicioSesionDTO usuario;
	private Cliente cliente;
	private DetalleVentaDTO detalleDTO = new DetalleVentaDTO();
	
	

}
