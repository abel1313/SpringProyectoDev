package com.practica.dev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Venta extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column( name = "total_Venta")
	@NotNull( message = "El total de la venta no deberia estar vacio")
	@Size( min = 5, max = 25)
	private double totalVenta;
	
	@Column( name = "fecha_Venta")
	@NotNull( message = "La fecha es invalida")
	private String fechaVenta;
}
