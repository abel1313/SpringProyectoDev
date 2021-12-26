package com.practica.dev.dto;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.practica.dev.model.Cliente;
import com.practica.dev.model.DetalleVenta;
import com.practica.dev.model.Producto;
import com.practica.dev.model.Usuario;
import com.practica.dev.model.Venta;
import com.practica.dev.model.Base;

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
public class DetalleVentaDTO extends Base{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double subtotalDetalle;
	
	private double precioDetalle;
	
	private double kilosDetalle;
	
	private List<Producto> listaProducto;

	

	
	
}
