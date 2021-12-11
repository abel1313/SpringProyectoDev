package com.practica.dev.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practica.dev.model.Producto;
import com.practica.dev.model.TrabajoCasa;
import com.practica.dev.service.ProductoServiceImpl;
import com.practica.dev.service.TrabajoCasaServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("proyecto/trabajoCasa")
public class TrabajoCasaController extends BaseControllerImpl<TrabajoCasa, TrabajoCasaServiceImpl> {

}
