package com.practica.dev.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trabajo")
public class Trabajo  extends Base{
	
	@Column(name="nombre")
	private String nombreTrabajo;
	
	@ManyToOne
	@JoinColumn( name = "trabajo_id")
	private TrabajoCasa trabajoCasa;
	

}
