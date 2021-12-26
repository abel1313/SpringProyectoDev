package com.practica.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practica.dev.model.Usuario;
import com.practica.dev.model.Vistas;
import com.practica.dev.service.IClienteUsuarioService;
import com.practica.dev.service.IVistaService;
import com.practica.dev.service.UsuarioServiceImpl;
import com.practica.dev.service.VistaServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("proyecto/vistas")
public class VistaController extends BaseControllerImpl<Vistas, VistaServiceImpl>{
	
	@Autowired
	private IVistaService iVistaService;
	
	
	@GetMapping("obtenerVistas")
	public ResponseEntity<?> obtenerVistas( ) throws Exception {
		 return ResponseEntity.status(HttpStatus.OK).body(this.iVistaService.obtenerVistas());
	
	}

}
