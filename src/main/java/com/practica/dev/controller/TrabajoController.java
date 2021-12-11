package com.practica.dev.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practica.dev.model.Producto;
import com.practica.dev.model.Trabajo;
import com.practica.dev.service.ProductoServiceImpl;
import com.practica.dev.service.TrabajoServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("proyecto/trabajo")
public class TrabajoController extends BaseControllerImpl<Trabajo, TrabajoServiceImpl> {
	

}
