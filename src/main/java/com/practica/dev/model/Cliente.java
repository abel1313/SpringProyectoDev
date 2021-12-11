package com.practica.dev.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table( name = "cliente")
public class Cliente extends Base{
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_Id", referencedColumnName = "id")
	private Persona personaCliente;

}
