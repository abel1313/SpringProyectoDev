
package com.practica.dev.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.practica.dev.model.Base;
import com.practica.dev.model.DetalleVenta;
import com.practica.dev.model.Usuario;
import com.practica.dev.model.Venta;

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
public class PedidoDTO extends Base{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fechaPedido;
	private String estatusPedido;
	private Venta venta;
	private InicioSesionDTO usuario;
	private Double totalKilos;
	

}
