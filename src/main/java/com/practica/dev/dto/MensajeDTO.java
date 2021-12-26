package com.practica.dev.dto;

import com.practica.dev.model.Base;

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
public class MensajeDTO extends Base{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mensaje; 
	

}
