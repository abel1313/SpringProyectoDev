package com.practica.dev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practica.dev.dto.ClienteUsuarioDTO;
import com.practica.dev.dto.MostrarClienteDTO;
import com.practica.dev.dto.RespuestaDTO;
import com.practica.dev.model.Cliente;
import com.practica.dev.model.ClienteUsuario;
import com.practica.dev.model.Direccion;
import com.practica.dev.model.Permisos;
import com.practica.dev.model.Persona;
import com.practica.dev.model.Usuario;
import com.practica.dev.service.DireccionServiceImpl;
import com.practica.dev.service.IClienteService;
import com.practica.dev.service.IClienteServiceImpl;
import com.practica.dev.service.IClienteUsuarioService;
import com.practica.dev.service.IDireccioneService;
import com.practica.dev.service.IPermisosService;
import com.practica.dev.service.IPersonaService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("proyecto/clientes")
public class ClienteController extends BaseControllerImpl<Cliente, IClienteServiceImpl> {
	
	@Autowired
	private IDireccioneService iServiceDireccion;
	
	@Autowired
	private IPersonaService iPersonaService;
	
	@Autowired
	private IClienteService iClienteService;
	
	@Autowired
	private IClienteUsuarioService iClienteUsuarioService;
	
	
	@GetMapping("/obtenerClientes")
	public ResponseEntity<?> obtenerClientes() throws Exception {

		return ResponseEntity.status(HttpStatus.OK).body(this.iClienteService.obtenerClientes());
	
	}
	
	
	@PostMapping("/guardarCliente")
	public ResponseEntity<?> save(@Valid @RequestBody ClienteUsuarioDTO clienteUsuarioDTO) throws Exception {
		
		if( clienteUsuarioDTO != null)
		{
			try {
				
				RespuestaDTO<Cliente> respuesta = new RespuestaDTO<Cliente>();
				respuesta.setCode("200 OK");
				respuesta.setCodeValue(200);
				respuesta.setMensaje("Se guardo el cliente corectamente");
				
				Cliente cli = this.iClienteService.save(clienteUsuarioDTO.getCliente());
				
				if( clienteUsuarioDTO.getUsuario().getId() != 0)
				{
					ClienteUsuario cliUsu = new ClienteUsuario();
					Usuario u = new Usuario();
					u.setId(clienteUsuarioDTO.getUsuario().getId());
					cliUsu.setUsuario(u);
					cliUsu.setCliente(cli);
					iClienteUsuarioService.save(cliUsu);
				}
				
				respuesta.setT(cli);
				
				 return ResponseEntity.status(HttpStatus.OK).body(respuesta);
				}catch( Exception es)
				{
					System.out.println(es);
					RespuestaDTO<Cliente> respuestaError = new RespuestaDTO<Cliente>();
					respuestaError.setCode("200 OK");
					respuestaError.setCodeValue(404);
					respuestaError.setMensaje("Ocurrio un error al guardar el cliente");
					respuestaError.setT(null);
					
					
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuestaError);
				}
		}else
		{
			RespuestaDTO<Cliente> respuestaError = new RespuestaDTO<Cliente>();
			respuestaError.setCode("200 OK");
			respuestaError.setCodeValue(404);
			respuestaError.setMensaje("Los datos no son los correctos");
			respuestaError.setT(null);
				
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuestaError);
		}
	}
	
	@DeleteMapping("/eliminarCliente/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {
			if( id != null )
			{
				if( service.delete(id) )
				{
					RespuestaDTO<Cliente> respuesta = new RespuestaDTO<Cliente>();
					respuesta.setCode("200 OK");
					respuesta.setCodeValue(200);
					respuesta.setMensaje("El cliente se elimino correctamente");
					respuesta.setT(new Cliente());
					 return ResponseEntity.status(HttpStatus.OK).body( respuesta );
				}else
				{
					RespuestaDTO<Cliente> respuesta = new RespuestaDTO<Cliente>();
					respuesta.setCode("200 OK");
					respuesta.setCodeValue(200);
					respuesta.setMensaje("No se pudo eliminar el cliente");
					respuesta.setT(new Cliente());
					 return ResponseEntity.status(HttpStatus.OK).body( respuesta );
				}
				
			}else
			{
				RespuestaDTO<Cliente> respuesta = new RespuestaDTO<Cliente>();
				respuesta.setCode("200 OK");
				respuesta.setCodeValue(200);
				respuesta.setMensaje("No se pudo eliminar el cliente");
				respuesta.setT(new Cliente());
				 
				 
				 return ResponseEntity.status(HttpStatus.OK).body(respuesta);
			}
			
			}catch( Exception es)
			{
				RespuestaDTO<Cliente> respuesta = new RespuestaDTO<Cliente>();
				respuesta.setCode("200 OK");
				respuesta.setCodeValue(200);
				respuesta.setMensaje("No se pudo eliminar el cliente");
				respuesta.setT(new Cliente());
				
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
			}
	}
	
	@GetMapping("/buscarId/{id}")
	public ResponseEntity<?> buscarClienteId(@PathVariable Integer id) throws Exception {
		// TODO Auto-generated method stub
		
		RespuestaDTO<Optional<Cliente>> respuesta = new RespuestaDTO<>();
		
		try {
			if( id != null )
			{
				respuesta.setCode("200 OK");
				respuesta.setCodeValue(200);
				respuesta.setMensaje("Datos del cliente para editar");
				Optional<Cliente> listaCliente = !this.iClienteService.getOne(id).isEmpty() ? this.iClienteService.getOne(id) : Optional.empty() ;
				respuesta.setT(listaCliente);
		
				 return ResponseEntity.status(HttpStatus.OK).body(respuesta);
			}else
			{
				
				respuesta.setCode("200 OK");
				respuesta.setCodeValue(200);
				respuesta.setMensaje("El cliente no se encontro");
				respuesta.setT( Optional.empty() );
				 
				 
				 return ResponseEntity.status(HttpStatus.OK).body(respuesta);
			}
			
			}catch( Exception es)
			{
				
				respuesta.setCode("200 OK");
				respuesta.setCodeValue(200);
				respuesta.setMensaje("El cliente no se encontro");
				respuesta.setT(Optional.empty());
				
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
			}
	}
	
	
	
	

}
