package com.practica.dev.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.dev.dto.MostrarClienteDTO;
import com.practica.dev.dto.RespuestaDTO;
import com.practica.dev.model.Cliente;
import com.practica.dev.repository.IBaseRepository;
import com.practica.dev.repository.IClienteRepository;
import com.practica.dev.repository.IPersonaRepository;

@Service
public class IClienteServiceImpl extends BaseServiceImpl<Cliente, Integer>
implements IClienteService {
	
	@Autowired
	private IClienteRepository iClienteRepository;
	
	
	
	public IClienteServiceImpl(IBaseRepository<Cliente, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}



	@Override
	public RespuestaDTO<Stream<MostrarClienteDTO>> obtenerClientes() throws Exception {
		RespuestaDTO<Stream<MostrarClienteDTO>> respuesta = new RespuestaDTO<>();
		try {
			
			List<Cliente> clientes = this.iClienteRepository.findAll();
			if( !clientes.isEmpty() )
			{
				
				Stream<MostrarClienteDTO> lst = clientes.stream().map((Cliente cliente)->{
				 	MostrarClienteDTO clienteMostrar = new MostrarClienteDTO();
				 	clienteMostrar.setId(cliente.getId());
				 	clienteMostrar.setNombre(cliente.getPersonaCliente().getNombrePersona());
				 	String apeidos = cliente.getPersonaCliente().getApeidoPaternoPersona() + " " +cliente.getPersonaCliente().getApeidoMaternoPersona();
				 	String estado = cliente.getPersonaCliente().getDireccion().getEstadoDireccion() + " " +cliente.getPersonaCliente().getDireccion().getColoniaDireccion();
				 	clienteMostrar.setApeidos(apeidos);
				 	clienteMostrar.setEstado(estado);
					return clienteMostrar;
				});
				
				respuesta.setCode("200 OK");
				respuesta.setCodeValue(200);
				respuesta.setMensaje("Se encontraron clientes");
				respuesta.setT(lst);
				return respuesta;
			
				
			}else
			{
				respuesta.setCode("200 OK");
				respuesta.setCodeValue(404);
				respuesta.setMensaje("No existen clientes en la base de datos");
				respuesta.setT(Stream.empty());
				return respuesta;
			}
		} catch (Exception e) {
			Exception exeption = new Exception(e.getMessage());
			Stream<MostrarClienteDTO> datos = Stream.empty();
			respuesta.setCode("200 OK");
			respuesta.setCodeValue(500);
			respuesta.setMensaje("Error con el servidor "+ exeption);
			respuesta.setT(datos);
			return respuesta;
			
		}
		
	
	}



}
