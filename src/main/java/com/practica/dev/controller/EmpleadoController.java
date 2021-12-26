package com.practica.dev.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practica.dev.model.Direccion;
import com.practica.dev.model.Empleado;
import com.practica.dev.service.DireccionServiceImpl;
import com.practica.dev.service.EmpleadoServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("proyecto/empleados")
public class EmpleadoController extends BaseControllerImpl<Empleado, EmpleadoServiceImpl>{

}
