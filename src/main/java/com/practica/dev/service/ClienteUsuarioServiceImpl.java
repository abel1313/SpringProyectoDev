package com.practica.dev.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.practica.dev.dto.ClienteUsuarioDTO;
import com.practica.dev.dto.InicioSesionDTO;
import com.practica.dev.dto.RespuestaDTO;
import com.practica.dev.model.ClienteUsuario;
import com.practica.dev.model.Usuario;
import com.practica.dev.repository.IBaseRepository;
import com.practica.dev.repository.IClienteUsuarioRepository;

@Service
public class ClienteUsuarioServiceImpl extends BaseServiceImpl<ClienteUsuario, Integer>implements IClienteUsuarioService{

	@Autowired
	private IClienteUsuarioRepository iClienteUsuarioRepository;
	
	public ClienteUsuarioServiceImpl(IBaseRepository<ClienteUsuario, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

	@Override
	public RespuestaDTO<ClienteUsuarioDTO> obtenerUsuarioId(@RequestBody Usuario usuario) throws Exception {
		RespuestaDTO<ClienteUsuarioDTO> respuesta = new RespuestaDTO<>();

		try {
	
			ClienteUsuario us = this.iClienteUsuarioRepository.findByUsuarioId(usuario.getId());
			if( us.getCliente()  != null )
			{
				ClienteUsuarioDTO clienteUsuarioDTO = new ClienteUsuarioDTO();
				clienteUsuarioDTO.setId(us.getId());
				clienteUsuarioDTO.setCliente(us.getCliente());
				Usuario u = us.getUsuario();
				InicioSesionDTO inicioSesionDTO = new InicioSesionDTO();
				inicioSesionDTO.setId(u.getId());
				inicioSesionDTO.setNombreUsuario(u.getNombreUsuario());
				inicioSesionDTO.setPermisos(u.getPermisos());
				clienteUsuarioDTO.setUsuario(inicioSesionDTO);
				
				respuesta.setCode("200 OK");
				respuesta.setCodeValue(200);
				respuesta.setMensaje("Proceda a la venta");
				respuesta.setT(clienteUsuarioDTO);
				return respuesta;
			}else
			{
		
				respuesta.setCode("200 OK");
				respuesta.setCodeValue(200);
				respuesta.setMensaje("No puede realizar una venta, es necesario que se registre como cliente");
				respuesta.setT(new ClienteUsuarioDTO());
				return respuesta;
			}
//			respuesta.setCode("200 OK");
//			respuesta.setCodeValue(200);
//			respuesta.setMensaje("Bienvenido");
//			respuesta.setT(null);
//			return respuesta;
//			


		} catch (Exception e) {
//		throw new Exception(e.getMessage());


		respuesta.setCode("200 OK");
		respuesta.setCodeValue(200);
		respuesta.setMensaje("Surgio un error al registrar "+e.getMessage());
		respuesta.setT(new ClienteUsuarioDTO());
		return respuesta;

		}

//		respuesta.setCode("200 OK");
//		respuesta.setCodeValue(404);
//		respuesta.setMensaje("Datos incorrectos");
//		respuesta.setT(null);
//		return respuesta;
		
	}

	@Override
	public RespuestaDTO<ClienteUsuarioDTO> buscarDatosId(Integer id) throws Exception {
		RespuestaDTO<ClienteUsuarioDTO> respuesta = new RespuestaDTO<>();

		try {
				ClienteUsuario us = this.iClienteUsuarioRepository.findByUsuarioId(id);
			if( us.getCliente()  != null )
			{
				ClienteUsuarioDTO clienteUsuarioDTO = new ClienteUsuarioDTO();
				clienteUsuarioDTO.setId(us.getId());
				clienteUsuarioDTO.setCliente(us.getCliente());
				Usuario u = us.getUsuario();
				InicioSesionDTO inicioSesionDTO = new InicioSesionDTO();
				inicioSesionDTO.setId(u.getId());
				inicioSesionDTO.setNombreUsuario(u.getNombreUsuario());
				inicioSesionDTO.setPermisos(u.getPermisos());
				clienteUsuarioDTO.setUsuario(inicioSesionDTO);
				
				respuesta.setCode("200 OK");
				respuesta.setCodeValue(200);
				respuesta.setMensaje("Datos encontrados");
				respuesta.setT(clienteUsuarioDTO);
				return respuesta;
			}else
			{
		
				respuesta.setCode("200 OK");
				respuesta.setCodeValue(404);
				respuesta.setMensaje("Este cliente no tiene datos");
				respuesta.setT(new ClienteUsuarioDTO());
				return respuesta;
			}
//			respuesta.setCode("200 OK");
//			respuesta.setCodeValue(200);
//			respuesta.setMensaje("Bienvenido");
//			respuesta.setT(null);
//			return respuesta;
//			


		} catch (Exception e) {
//		throw new Exception(e.getMessage());


		respuesta.setCode("200 OK");
		respuesta.setCodeValue(500);
		respuesta.setMensaje("Surgio un error al registrar "+e.getMessage());
		respuesta.setT(new ClienteUsuarioDTO());
		return respuesta;

		}

//		respuesta.setCode("200 OK");
//		respuesta.setCodeValue(404);
//		respuesta.setMensaje("Datos incorrectos");
//		respuesta.setT(null);
//		return respuesta;
		
	}
	
}
