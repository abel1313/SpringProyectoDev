package com.practica.dev.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practica.dev.model.Pedido;
import com.practica.dev.service.PedidoServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("proyecto/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{

	@GetMapping("obtenerPedidos")
	public ResponseEntity<?> obtenerUsuarios() throws Exception {

		 return ResponseEntity.status(HttpStatus.OK).body(service.obtenerPedidos());
	
	}
	
	
}
