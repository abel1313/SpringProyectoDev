package com.practica.dev.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



public class ResourceNotFoundException extends RuntimeException {

	  private static final long serialVersionUID = 1L;

	  public ResourceNotFoundException(String msg) {
	    super(msg);
	  }


}
