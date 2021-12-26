package com.practica.dev.model;

import javax.persistence.Column;
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
@Table( name = "tipousuarios" )
public class TipoUsuario extends Base{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column( name = "tipo_usuario")
	private String tipoUsuario;
	
	@Column( name = "estatus")
	private String estatusUsuario;

}
