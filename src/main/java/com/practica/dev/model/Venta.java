package com.practica.dev.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Venta extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column( name = "total_Venta")
	@NotNull( message = "El total de la venta no deberia estar vacio")
	private double totalVenta;
	
	@Column( name = "fecha_Venta")
	@NotNull( message = "La fecha es invalida")
	private String fechaVenta;
	
	
	@OneToOne
	@JoinColumn(name = "cliente_Id")
	private Cliente cliente;
	
	@OneToOne
	@JoinColumn(name = "usuario_Id")
	private Usuario usuario;
	

//	@ManyToMany
//	@JsonBackReference
//	private List<DetalleVenta> listaProducto;
//	
//	@ManyToOne( fetch = FetchType.LAZY, optional = false)
//	@JoinColumn( name = "venta_Id") 
//	@JsonBackReference
//	private DetalleVenta detalle;
	
	
	
}
