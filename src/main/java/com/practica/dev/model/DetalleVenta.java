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
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.practica.dev.dto.DetalleDTO;
import com.practica.dev.dto.VentaDTO;

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
@Table( name = "detalle")
public class DetalleVenta extends Base{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	private Producto producto;
	

	

//	@ManyToMany
//	@JoinColumn( name = "venta_Id")
//	private List<Venta> venta;
	
	
//	@OneToMany( mappedBy = "detalle")
//	private List<Venta> venta;
	
	
	@Column( name = "subtotal_Detalle")
	@NotNull( message = "El Sub total no deberia estar vacio")
	@Min(0)
	private double subtotalDetalle;
	
	@Column( name = "precio_Detalle")
	@NotNull( message = "El total de la venta no deberia estar vacio")
	@Min(1)
	private double precioDetalle;
	
	@Column( name = "kilos_Detalle")
	@NotNull( message = "los kilos no deberia estar vacio")
	@Min(0)
	private double kilosDetalle;
	
	@OneToOne
	@JoinColumn( name = "producto_id")
	private Producto producto;
	
	
	@OneToOne
	@JoinColumn( name = "venta_id")
	private Venta venta;
	
	

	
	
	
}
