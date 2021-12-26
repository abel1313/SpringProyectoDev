package com.practica.dev.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.dev.dto.InicioSesionDTO;
import com.practica.dev.dto.MensajeDTO;
import com.practica.dev.dto.PedidoDTO;
import com.practica.dev.dto.RespuestaDTO;
import com.practica.dev.dto.VentaDetalleDTO;
import com.practica.dev.model.DetalleVenta;
import com.practica.dev.model.Pedido;
import com.practica.dev.model.Usuario;
import com.practica.dev.model.Venta;
import com.practica.dev.repository.IBaseRepository;
import com.practica.dev.repository.IDetalleRepository;
import com.practica.dev.repository.IPedidoRepository;
import com.practica.dev.repository.IVentaRepository;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Integer> implements IPedidoService {

	@Autowired
	private IPedidoRepository iPedidoRepository;
	
	@Autowired
	private IVentaRepository iVentaRepository;
	
	@Autowired
	private IDetalleRepository iDetalleRepository;

	public PedidoServiceImpl(IBaseRepository<Pedido, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

	@Override
	public RespuestaDTO<Optional<List<PedidoDTO>>> obtenerPedidos() throws Exception {
		RespuestaDTO<Optional<List<PedidoDTO>>> respuesta = new RespuestaDTO<>();

		try {

			List<Pedido> us = this.iPedidoRepository.findAll();

			if (!us.isEmpty()) {

				List<PedidoDTO> pedidosDTO = us.stream().map((Pedido pedido) -> {
					PedidoDTO enviarDTO = new PedidoDTO();
					enviarDTO.setEstatusPedido(pedido.getEstatusPedido());
					enviarDTO.setFechaPedido(pedido.getFechaPedido());
					enviarDTO.setId(pedido.getId());
					Usuario u = pedido.getUsuario();
					InicioSesionDTO inicio = new InicioSesionDTO();
					inicio.setId(u.getId());
					inicio.setNombreUsuario(u.getNombreUsuario());
					inicio.setPermisos(u.getPermisos());
					enviarDTO.setUsuario(inicio);
					enviarDTO.setVenta(pedido.getVenta());
					return enviarDTO;
				}).collect(Collectors.toList());

				respuesta.setCode("200 OK");
				respuesta.setCodeValue(200);
				respuesta.setMensaje("Se encontraron pedidos");
				respuesta.setT(Optional.of(pedidosDTO));

			} else {
				respuesta.setCode("200 OK");
				respuesta.setCodeValue(404);
				respuesta.setMensaje("No existen pedido");
				respuesta.setT(Optional.empty());

			}

		} catch (Exception e) {
//			throw new Exception(e.getMessage());

			respuesta.setCode("200 OK");
			respuesta.setCodeValue(500);
			respuesta.setMensaje("Error en el servidor");
			respuesta.setT(Optional.empty());
			return respuesta;

		}

		return respuesta;
	}

	@Override
	public RespuestaDTO<Optional<MensajeDTO>> guardarPedido(VentaDetalleDTO ventaDetalleDTO) throws Exception {
		RespuestaDTO<Optional<MensajeDTO>> res = new RespuestaDTO<>();
		try {
				System.err.println(ventaDetalleDTO.getProducto().size() + "  tamano");
			if( ventaDetalleDTO != null )
			{
				Venta venta =  this.iVentaRepository.save(ventaDetalleDTO.getVenta());
						
				ventaDetalleDTO.getProducto().forEach((producto)->{

					DetalleVenta detalle = new DetalleVenta();
					detalle.setVenta(venta);
					detalle.setKilosDetalle(Double.parseDouble(producto.getKiloProducto()) );
					detalle.setPrecioDetalle(producto.getPrecioProducto());
					detalle.setProducto(producto);
					detalle.setSubtotalDetalle( (producto.getPrecioProducto() * Double.parseDouble(producto.getKiloProducto()) ) );
					DetalleVenta det = this.iDetalleRepository.save(detalle);
					
				});
				List<DetalleVenta> list = this.iDetalleRepository.findByVentaId(venta.getId());
				double totalVenta = list.stream()
						.filter((total)-> total.getVenta().getId() == venta.getId() )
						.mapToDouble((sub)-> sub.getSubtotalDetalle())
						.sum();
				venta.setTotalVenta(totalVenta);
				Venta ventaTotal =  this.iVentaRepository.save(venta);
				Pedido pedido = new Pedido();
				  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				pedido.setFechaPedido(dtf.format(LocalDateTime.now()));
				pedido.setUsuario(venta.getUsuario());
				pedido.setEstatusPedido("En camino");
				pedido.setVenta(ventaTotal);
				Pedido pedidoGuardado = this.iPedidoRepository.save(pedido);
				
				res.setCode("200 OK");
				res.setCodeValue(200);
				res.setMensaje("Pedido realizado");
				res.setT(Optional.of(new MensajeDTO("Se realizó correctamente el pedido")));
	
			}
				
		} catch (Exception e) {
//				throw new Exception(e.getMessage());

			System.err.println(" nada mas " + e.getMessage());
			
			res.setCode("200 OK");
			res.setCodeValue(500);
			res.setMensaje("Errar del lado de servidor");
			res.setT(Optional.of(new MensajeDTO("Los datos del pedido son incorrectos")));
			return res;
			
		}
		return res;
	}
}
