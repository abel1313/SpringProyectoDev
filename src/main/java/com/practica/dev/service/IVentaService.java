package com.practica.dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.practica.dev.dto.DetalleVentaDTO;
import com.practica.dev.dto.MensajeDTO;
import com.practica.dev.dto.PedidoDTO;
import com.practica.dev.dto.RespuestaDTO;
import com.practica.dev.dto.VentaDTO;
import com.practica.dev.dto.VentaDetalleDTO;
import com.practica.dev.model.DetalleVenta;
import com.practica.dev.model.Usuario;
import com.practica.dev.model.Venta;

public interface IVentaService extends IBaseService<Venta, Integer> {
	
	

	public RespuestaDTO<Optional<VentaDTO>> obtenerVenta() throws Exception;
	public RespuestaDTO<Optional<MensajeDTO>> generarVenta(@RequestBody VentaDetalleDTO ventaDetalleDTO ) throws Exception;

}
