package com.practica.dev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

@Table( name = "pedido")
public class Pedido extends Base{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column( name = "fecha_pedido")
	private String fechaPedido;
	

	@Column( name = "estatus_pedido", nullable = true)
	private String estatusPedido;
	
	@OneToOne
	@JoinColumn( name = "venta_id" )
	private Venta venta;
	
	@OneToOne
	@JoinColumn( name = "usuario_id" )
	private Usuario usuario;
	


}
