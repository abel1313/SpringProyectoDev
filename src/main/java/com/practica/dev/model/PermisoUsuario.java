package com.practica.dev.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@Table( name = "permisosusuario")
public class PermisoUsuario extends Base{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

//	@ManyToOne( fetch = FetchType.EAGER )
//	@JoinColumn( name = "vista_id", nullable = false )
//	@JsonBackReference
//	private Vistas vista;
	
//	@ManyToOne( fetch = FetchType.EAGER)
//	@JoinColumn(name = "usuario_id")
//	@JsonBackReference
//	private Usuario usuario;
	
	
//	@ManyToOne()
//	@JoinColumn( name = "tipo_usuario_id")
//	private TipoUsuario tipoUsuario;
//	

	

}
