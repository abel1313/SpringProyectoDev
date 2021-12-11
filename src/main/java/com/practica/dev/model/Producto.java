package com.practica.dev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
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
public class Producto extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column( name = "nombre_Producto")
	@NotNull( message = "El nombre no deberia ser vacio")
	@Size( min = 5, max = 25)
	private String nombreProducto;
	
	@Column( name = "precio_Producto")
	@NotNull( message = "El precio no deberia ser vacio")
	@Min(1)
	private double precioProducto;
	
	@Column( name = "descripcion_Producto")
	@NotNull( message = "La descripcion no deberia ser vacio")
	@Size( min = 5, max = 255)
	private String descripcionProducto;
	
	@Column( name = "kilo_Producto")
	@NotNull( message = "El kilo no deberia ser vacio")	
	private String kiloProducto;



}
