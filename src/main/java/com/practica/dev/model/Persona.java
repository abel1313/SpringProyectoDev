package com.practica.dev.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table( name = "persona")
public class Persona extends Base{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column( name = "nombre_Persona")
	@NotNull( message = "El nombre no deberia ser vacio")
	@Size( min = 3, max = 25)
	private String nombrePersona;
	
	@Column( name = "apeido_Paterno_Persona")
	@NotNull( message = "El apeido paterno no deberia ser vacio")
	@Size( min = 3, max = 25)
	private String apeidoPaternoPersona;
	
	@Column( name = "apeido_Materno_Persona")
	@NotNull( message = "El apeido materno no deberia ser vacio")
	@Size( min = 3, max = 25)
	private String apeidoMaternoPersona;
	
	@Column( name = "genero_Persona")
	@NotNull( message = "El genero no deberia ser vacio")
	@Size( min = 3, max = 10)
	private String generoPersona;
	

	@Column( name = "fecha_nacimiento")
	private String fechaNacimiento;
	
	@OneToOne( cascade = CascadeType.ALL)
	@JoinColumn(name = "direccion_Id", referencedColumnName = "id")
	private Direccion direccion;


	
	
	

}
