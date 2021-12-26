package com.practica.dev.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practica.dev.model.DetalleVenta;
import com.practica.dev.model.Direccion;
import com.practica.dev.service.DetalleServiceImpl;
import com.practica.dev.service.DireccionServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("proyecto/detalle")
public class DetalleController extends BaseControllerImpl<DetalleVenta, DetalleServiceImpl>{

}
