package com.practica.dev.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.jni.File;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practica.dev.dto.VentaDetalleDTO;
import com.practica.dev.model.Base64;
import com.practica.dev.model.Direccion;
import com.practica.dev.model.Empleado;
import com.practica.dev.service.DireccionServiceImpl;
import com.practica.dev.service.EmpleadoServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("proyecto/empleados")
public class EmpleadoController extends BaseControllerImpl<Empleado, EmpleadoServiceImpl>
{
	

	@PostMapping("base64")
	public ResponseEntity<?> realizarVenta(@RequestBody Base64 base64) throws Exception {
		
		byte [] base64Decoder = null;

		base64Decoder = java.util.Base64.getDecoder().decode(base64.getBase64());

		String stringDecode = new String(base64Decoder, StandardCharsets.UTF_8);	
		String [] datos = stringDecode.split("\n");
		
		for(String string: datos)
		{
			String [] partes = string.split("\t");
			System.err.println(partes[0]);
			System.err.println(partes[1]);
			System.err.println(partes[2]);
		}
		
		 return ResponseEntity.status(HttpStatus.OK).body(null);
	
	}
	

}
