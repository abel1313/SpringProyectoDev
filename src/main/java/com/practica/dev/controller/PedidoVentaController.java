package com.practica.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practica.dev.dto.VentaDetalleDTO;
import com.practica.dev.model.PedidoVenta;
import com.practica.dev.service.IDetalleService;
import com.practica.dev.service.IPedidoService;
import com.practica.dev.service.PedidoVentaServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("proyecto/pedidosVenta")
public class PedidoVentaController extends BaseControllerImpl<PedidoVenta, PedidoVentaServiceImpl>{

	@Autowired
	private IPedidoService iPedidoService;
	
	@Autowired
	private IDetalleService iDetalleService;
	
	@PostMapping("realizarPedido")
	public ResponseEntity<?> realizarVenta(@RequestBody VentaDetalleDTO ventaDetalleDTO) throws Exception {
		 return ResponseEntity.status(HttpStatus.OK).body(this.iPedidoService.guardarPedido(ventaDetalleDTO));
	
	}
}
