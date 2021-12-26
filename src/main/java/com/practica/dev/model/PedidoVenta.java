package com.practica.dev.model;

import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table(name = "pedidoventa")
public class PedidoVenta extends Base{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String estatus;

}
