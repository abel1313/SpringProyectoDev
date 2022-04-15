package com.practica.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practica.dev.exception.ResourceNotFoundException;
import com.practica.dev.model.Ejemplo;
import com.practica.dev.model.Usuario;
import com.practica.dev.service.EnvioCorreoService;
import com.practica.dev.service.IUsuarioService;
import com.practica.dev.service.UsuarioServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("proyecto/usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl> {

	@Autowired
	private IUsuarioService iUsuarioService;
	
	@Autowired
	private EnvioCorreoService envioCorreo;
	

	@PostMapping("iniciarSesion")
	public ResponseEntity<?> iniciarSesion( @RequestBody Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
 
//		envioCorreo.sendEmail("abel_azul_13@hotmail.com", "Gola", "Mensaje");
		try {
		 return ResponseEntity.status(HttpStatus.OK).body(this.iUsuarioService.iniciarSesion(usuario.getNombreUsuario(), usuario.getContrasenaUsuario()));
		}catch( Exception e)
		{
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new ResourceNotFoundException(e.getMessage()) );
		}
	}
	
	@GetMapping("existeUsuario/{nombreUsuario}")
	public ResponseEntity<?> iniciarSesion( @PathVariable String nombreUsuario) throws Exception {

		 return ResponseEntity.status(HttpStatus.OK).body(this.iUsuarioService.existeUsuario(nombreUsuario));
	
	}
	
	@PostMapping("/registrarUsuario")
	public ResponseEntity<?> registrarUsuario( @RequestBody Usuario usuario) throws Exception {

	
		 return ResponseEntity.status(HttpStatus.OK).body(service.registrarUsuario(usuario));
	
	}
	
	@GetMapping("obtenerUsuario")
	public ResponseEntity<?> obtenerUsuarios() throws Exception {

		 return ResponseEntity.status(HttpStatus.OK).body(service.obtenerUsuarioPermisos());
	
	}
	
	
	@PostMapping("otro")
	public ResponseEntity<?> otro( @RequestBody List<Ejemplo> ejemplo) throws Exception {

		 return ResponseEntity.status(HttpStatus.OK).body(ejemplo);
	
	}
	
	
	
}
