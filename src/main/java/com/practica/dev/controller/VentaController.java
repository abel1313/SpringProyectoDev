package com.practica.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practica.dev.dto.VentaDetalleDTO;
import com.practica.dev.model.Venta;
import com.practica.dev.model.Vistas;
import com.practica.dev.service.IVentaService;
import com.practica.dev.service.VentaServiceImpl;
import com.practica.dev.service.VistaServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("proyecto/ventas")
public class VentaController extends BaseControllerImpl<Venta, VentaServiceImpl>{
	
	@Autowired
	private IVentaService iVentaService;
	
	
	@GetMapping("obtenerVenta")
	public ResponseEntity<?> obtenerVistas( ) throws Exception {
		 return ResponseEntity.status(HttpStatus.OK).body(this.iVentaService.obtenerVenta());
	
	}
	
	@PostMapping("realizarVenta")
	public ResponseEntity<?> realizarVenta(@RequestBody VentaDetalleDTO ventaDetalleDTO) throws Exception {
		System.err.println(ventaDetalleDTO + " venta");
		 return ResponseEntity.status(HttpStatus.OK).body(this.iVentaService.generarVenta(ventaDetalleDTO));
	
	}
	

}
