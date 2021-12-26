package com.practica.dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.dev.dto.RespuestaDTO;
import com.practica.dev.model.Usuario;
import com.practica.dev.model.Vistas;
import com.practica.dev.repository.IBaseRepository;
import com.practica.dev.repository.IVistaRepository;

@Service
public class VistaServiceImpl extends BaseServiceImpl<Vistas, Integer>
implements IVistaService{

	@Autowired
	private IVistaRepository iVistaRepository;
	public VistaServiceImpl(IBaseRepository<Vistas, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}
	@Override
	public RespuestaDTO<Optional<List<Vistas>>> obtenerVistas() throws Exception{
		// 
		RespuestaDTO<Optional<List<Vistas>>> vistaDTO = new RespuestaDTO<>();
		try {
			Optional<List<Vistas>> vista = Optional.of(this.iVistaRepository.findAll());
			if( vista.isPresent())
			{
				vistaDTO.setCode("200 OK");
				vistaDTO.setCodeValue(200);
				vistaDTO.setMensaje("Vistas a mostrar");
				vistaDTO.setT(vista);
			}else
			{
				vistaDTO.setCode("200 OK");
				vistaDTO.setCodeValue(404);
				vistaDTO.setMensaje("No existen vistas");
				vistaDTO.setT(vista);
			}
			return vistaDTO;
		}catch(Exception exception)
		{
			 Exception exe = new Exception(exception.getMessage());
			vistaDTO.setCode("200 OK");
			vistaDTO.setCodeValue(500);
			vistaDTO.setMensaje("No existen vistas "+exe.getMessage());
			vistaDTO.setT(Optional.empty());
			return vistaDTO;
		}
	}
	
	

}
