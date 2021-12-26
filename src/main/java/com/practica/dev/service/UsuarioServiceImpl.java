package com.practica.dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.practica.dev.dto.InicioSesionDTO;
import com.practica.dev.dto.RespuestaDTO;
import com.practica.dev.model.ClienteUsuario;
import com.practica.dev.model.Permisos;
import com.practica.dev.model.Usuario;
import com.practica.dev.model.Vistas;
import com.practica.dev.repository.IBaseRepository;
import com.practica.dev.repository.IUsuarioRepository;
import java.util.stream.Stream;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Integer> implements IUsuarioService {

	@Autowired
	private IUsuarioRepository iUsuarioRepository;

	@Autowired
	private IVistaService iVistaService;

	@Autowired
	private IPermisosService iPermisosService;
	
	@Autowired
	private IClienteUsuarioService iClienteUsuarioService;

	public UsuarioServiceImpl(IBaseRepository<Usuario, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

	@Override
	public RespuestaDTO<Stream<InicioSesionDTO>> iniciarSesion(@PathVariable String nombreUsuario,
			@PathVariable String contrasenaUsuario) throws Exception {
		//
		RespuestaDTO<Stream<InicioSesionDTO>> respuesta = new RespuestaDTO<>();

		try {
			String contrasenaEncriptada = DigestUtils.md5Hex(contrasenaUsuario);

			List<Usuario> us = this.iUsuarioRepository.findByNombreUsuarioAndContrasenaUsuario(nombreUsuario,
					contrasenaEncriptada);
			if (us.size() > 0) {
				respuesta.setCode("200 OK");
				respuesta.setCodeValue(200);
				respuesta.setMensaje("Bienvenido");

				Stream<InicioSesionDTO> inicioSesion = us.stream().map((Usuario u) -> {
					InicioSesionDTO inicio = new InicioSesionDTO();
					inicio.setId(u.getId());
					inicio.setNombreUsuario(u.getNombreUsuario());
					inicio.setPermisos(u.getPermisos());
					return inicio;
				});
				respuesta.setT(inicioSesion);
				
			
				return respuesta;
			}

		} catch (Exception e) {
//			throw new Exception(e.getMessage());

			respuesta.setCode("200 OK");
			respuesta.setCodeValue(500);
			respuesta.setMensaje("Error en el servidor");
			respuesta.setT(Stream.empty());
			return respuesta;

		}

		respuesta.setCode("200 OK");
		respuesta.setCodeValue(404);
		respuesta.setMensaje("Datos incorrectos");
		respuesta.setT(Stream.empty());
		return respuesta;
	}

	@Override
	public RespuestaDTO<Boolean> existeUsuario(@PathVariable String nombreUsuario) throws Exception {
		//
		RespuestaDTO<Boolean> respuesta = new RespuestaDTO<>();

		try {
			List<Usuario> existe = this.iUsuarioRepository.findByNombreUsuario(nombreUsuario);
			if (!existe.isEmpty()) {
				respuesta.setCode("200 OK");
				respuesta.setCodeValue(200);
				respuesta.setMensaje("El nombre de usuario que ingreso ya esta en uso, ingrese uno diferente");
				respuesta.setT(true);
				return respuesta;
			} else {
				respuesta.setCode("200 OK");
				respuesta.setCodeValue(200);
				respuesta.setMensaje("El nombre de usuario esta disponible");
				respuesta.setT(false);
				return respuesta;
			}
		} catch (Exception e) {
//			throw new Exception(e.getMessage());

			respuesta.setCode("200 OK");
			respuesta.setCodeValue(500);
			respuesta.setMensaje("Ocurrio un error con el servidor");
			respuesta.setT(null);
			return respuesta;

		}
	}

	@Override
	public RespuestaDTO<Boolean> registrarUsuario(@RequestBody Usuario usuario) throws Exception {
		//
		RespuestaDTO<Boolean> respuesta = new RespuestaDTO<>();

		RespuestaDTO<Boolean> verificarUsuario = existeUsuario(usuario.getNombreUsuario());
		if (verificarUsuario.getT()) {
			respuesta.setCode("200 OK");
			respuesta.setCodeValue(200);
			respuesta.setMensaje("El usuario ya existe, no se pudo crear el usuario");
			respuesta.setT(true);
			return respuesta;
		} else {

			try {

				String contrasenaEncriptada = DigestUtils.md5Hex(usuario.getContrasenaUsuario());
				usuario.setContrasenaUsuario(contrasenaEncriptada);

				Optional<Usuario> usuarioOptional = Optional.of(this.iUsuarioRepository.save(usuario));
			
				if (usuarioOptional.isPresent()) {
						List<Permisos> permisos = usuario.getPermisos();
					if (permisos.size() > 0) {
						permisos.forEach((per) -> {
							try {
								Permisos permiso = new Permisos();
								permiso.setUsuario(usuarioOptional.get());
								permiso.setVista(per.getVista());
								Permisos permisoGuardado = iPermisosService.save(permiso);
								
						
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						});
				
						respuesta.setCode("200 OK");
						respuesta.setCodeValue(200);
						respuesta.setMensaje("El usuario se agregó correctamente con los permisos correspondientes");
						respuesta.setT(true);
						return respuesta;
					}else
					{
						try {
							Permisos permisoRegistro = new Permisos();

							Permisos permisoRegistro2 = new Permisos();
							Vistas vista = new Vistas();
							vista.setId(4);
							vista.setNombreVista("Venta");
							Vistas vistaCliente = new Vistas();
							vistaCliente.setId(3);
							vistaCliente.setNombreVista("Cliente");
							permisoRegistro.setUsuario(usuarioOptional.get());
							permisoRegistro.setVista(vista);
							permisoRegistro2.setUsuario(usuarioOptional.get());
							permisoRegistro2.setVista(vistaCliente);
							
							Permisos permisoGuardado = iPermisosService.save(permisoRegistro);
							Permisos permisoClienteGuardado = iPermisosService.save(permisoRegistro2);
							
					
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					Usuario usuarioStream =  usuarioOptional.stream().map(m->m).findFirst().get();
					ClienteUsuario cliUsu = new ClienteUsuario();
					cliUsu.setUsuario(usuarioStream);
					this.iClienteUsuarioService.save(cliUsu);
			
					respuesta.setCode("200 OK");
					respuesta.setCodeValue(200);
					respuesta.setMensaje("El usuario se agregó correctamente");
					respuesta.setT(true);
					return respuesta;
				} else {
					respuesta.setCode("200 OK");
					respuesta.setCodeValue(200);
					respuesta.setMensaje("No se pudo guardar el usuario");
					respuesta.setT(false);
					return respuesta;
				}
			} catch (Exception e) {
//			throw new Exception(e.getMessage());

				respuesta.setCode("200 OK");
				respuesta.setCodeValue(500);
				respuesta.setMensaje("Ocurrio un error con el servidor "+ e.getMessage());
				respuesta.setT(null);
				return respuesta;

			}

		}

	}

	@Override
	public RespuestaDTO<List<InicioSesionDTO>> obtenerUsuarioPermisos() throws Exception {
		//
		RespuestaDTO<List<InicioSesionDTO>> respuesta = new RespuestaDTO<>();

		try {
			final List<Usuario> usuarios = this.iUsuarioRepository.findAll();
			if (!usuarios.isEmpty()) {
				List<InicioSesionDTO> listDTO = new ArrayList<InicioSesionDTO>();
				usuarios.forEach((usu) -> {
	
					InicioSesionDTO inicioSesionDTO = new InicioSesionDTO();
					inicioSesionDTO.setId(usu.getId());
					inicioSesionDTO.setNombreUsuario(usu.getNombreUsuario());
					inicioSesionDTO.setPermisos(usu.getPermisos());
					listDTO.add(inicioSesionDTO);
				});

				respuesta.setCode("200 OK");
				respuesta.setCodeValue(200);
				respuesta.setMensaje("Usuarios disponibles");
				respuesta.setT(listDTO);
				return respuesta;
			} else {
				respuesta.setCode("200 OK");
				respuesta.setCodeValue(200);
				respuesta.setMensaje("El nombre de usuario esta disponible");
				respuesta.setT(new ArrayList<InicioSesionDTO>());
				return respuesta;
			}
		} catch (Exception e) {
//			throw new Exception(e.getMessage());

			respuesta.setCode("200 OK");
			respuesta.setCodeValue(500);
			respuesta.setMensaje("Ocurrio un error con el servidor");
			respuesta.setT(new ArrayList<>());
			return respuesta;

		}
	}

}
