package com.practica.dev.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.practica.dev.dto.PedidoDTO;
import com.practica.dev.dto.InicioSesionDTO;
import com.practica.dev.dto.MensajeDTO;
import com.practica.dev.dto.RespuestaDTO;
import com.practica.dev.dto.VentaDetalleDTO;
import com.practica.dev.model.Pedido;
import com.practica.dev.model.Permisos;
import com.practica.dev.repository.IPedidoRepository;

public interface IPedidoService extends IBaseService<Pedido, Integer>{
	
	public RespuestaDTO<Optional<List<PedidoDTO>>> obtenerPedidos() throws Exception;
	
	public RespuestaDTO<Optional<MensajeDTO>> guardarPedido(@RequestBody VentaDetalleDTO ventaDetalleDTO ) throws Exception;

}
