package com.practica.dev.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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

@Table( name = "direccion")
public class Direccion extends Base{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column( name = "estado_Direccion")
	@NotNull( message = "El estado no deberia ser vacio")
	@Size( min = 3, max = 25)
	private String estadoDireccion;
	
	@Column( name = "calle_Direccion")
	@NotNull( message = "La calle no deberia ser vacio")
	@Size( min = 3, max = 25)
	private String calleDireccion;
	
	@Column( name = "colonia_Direccion")
	@NotNull( message = "La colonia no deberia estar vacio")
	@Size( min = 3, max = 25)
	private String coloniaDireccion;
	
	@Column( name = "codigo_Postal_Direccion")
	@NotNull( message = "El codigo postal no deberia estar vacio")
	@Size( min = 3, max = 25)
	private String codigoPostalDireccion;
	
	@Column( name = "numero_interior")
	@Size( min = 0, max = 10)
	private String numeroInterior;
	
	@Column( name = "numero_exterior")
	@Size( min = 0, max = 10)
	private String numeroExterior;
	
//	
//	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn( name = "direccion_Id", nullable = false, insertable =false, updatable=false)
//	private Persona persona;


	
	
	
	

}
