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

import com.practica.dev.dto.UsuarioClienteDTOID;
import com.practica.dev.dto.UsuarioDTO;
import com.practica.dev.model.ClienteUsuario;
import com.practica.dev.model.Usuario;
import com.practica.dev.service.ClienteUsuarioServiceImpl;
import com.practica.dev.service.IClienteUsuarioService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("proyecto/clienteUsuario")
public class ClienteUsuarioController extends BaseControllerImpl<ClienteUsuario, ClienteUsuarioServiceImpl>{

	@Autowired
	private IClienteUsuarioService iClienteUsuarioService;
	
	@PostMapping("obtenerClienteUsuario")
	public ResponseEntity<?> obtenerVistas( @RequestBody Usuario usuario) throws Exception {
		 return ResponseEntity.status(HttpStatus.OK).body(this.iClienteUsuarioService.obtenerUsuarioId(usuario));
	
	}
	
	@PostMapping("obtenerMisDatos")
	public ResponseEntity<?> obtenerDatosId( @RequestBody UsuarioClienteDTOID usuario) throws Exception {
		 return ResponseEntity.status(HttpStatus.OK).body(this.iClienteUsuarioService.buscarDatosId(usuario.getId()));
	
	}
	
	
}
