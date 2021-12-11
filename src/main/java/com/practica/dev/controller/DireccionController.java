package com.practica.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practica.dev.model.Direccion;
import com.practica.dev.service.BaseServiceImpl;
import com.practica.dev.service.DireccionServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("proyecto/direccion")
public class DireccionController extends BaseControllerImpl<Direccion, DireccionServiceImpl>{

}
