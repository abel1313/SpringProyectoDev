package com.practica.dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.dev.dto.DetalleDTO;
import com.practica.dev.dto.DetalleVentaDTO;
import com.practica.dev.dto.InicioSesionDTO;
import com.practica.dev.dto.MensajeDTO;
import com.practica.dev.dto.PedidoDTO;
import com.practica.dev.dto.RespuestaDTO;
import com.practica.dev.dto.VentaDTO;
import com.practica.dev.dto.VentaDetalleDTO;
import com.practica.dev.model.DetalleVenta;
import com.practica.dev.model.Pedido;
import com.practica.dev.model.Producto;
import com.practica.dev.model.Usuario;
import com.practica.dev.model.Venta;
import com.practica.dev.model.Vistas;
import com.practica.dev.repository.IBaseRepository;
import com.practica.dev.repository.IDetalleRepository;
import com.practica.dev.repository.IVentaRepository;

@Service
public class VentaServiceImpl extends BaseServiceImpl<Venta, Integer> implements IVentaService {

	@Autowired
	private IVentaRepository iVentaRepository;

	@Autowired
	private IDetalleRepository iDetalleRepository;

	public VentaServiceImpl(IBaseRepository<Venta, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

	@Override
	public RespuestaDTO<Optional<VentaDTO>> obtenerVenta() throws Exception {

		RespuestaDTO<Optional<VentaDTO>> res = new RespuestaDTO<>();
		try {

			List<DetalleVenta> detalle = this.iDetalleRepository.findAll();

			List<Producto> ptr = new ArrayList<Producto>();

			DetalleVentaDTO detDto = new DetalleVentaDTO();
			VentaDTO ventaDTO = new VentaDTO();
			
			Optional<Optional<Object>> ejem = Optional.empty();
			
			if (!detalle.isEmpty()) {
				detalle.forEach((dato)->{
					
					
					
					Producto p = dato.getProducto();
					ptr.add(p);
					detDto.setListaProducto(ptr);
					detDto.setId(dato.getId());
					detDto.setKilosDetalle(dato.getKilosDetalle());
					detDto.setPrecioDetalle(dato.getPrecioDetalle());
					detDto.setSubtotalDetalle(dato.getSubtotalDetalle());
				});
				System.out.println(detalle.stream().map((m)->m).findFirst());
				double totalVenta = detalle.stream().mapToDouble(( total )-> total.getSubtotalDetalle() ).sum();
				Optional<Venta> ves = detalle.stream().map((m)->m.getVenta()).findFirst();
				Optional<VentaDTO> ven2 = ves.map((v)->{
					VentaDTO ven= new VentaDTO();
					ven.setId(v.getId());
					ven.setCliente(v.getCliente());
					ven.setFechaVenta(v.getFechaVenta());
					ven.setTotalVenta(totalVenta);
					InicioSesionDTO ini = new InicioSesionDTO();
					ini.setId(v.getUsuario().getId());
					ini.setNombreUsuario(v.getUsuario().getNombreUsuario());
					ini.setPermisos(v.getUsuario().getPermisos());
					ven.setUsuario(ini);
					return ven;
				});
				
			
				ventaDTO = ven2.get();
				ventaDTO.setDetalleDTO(detDto);
				

	
				
			
					
				
				
				res.setCode("200 OK");
				res.setCodeValue(200);
				res.setMensaje("Venta de productos");
				res.setT(Optional.of(ventaDTO));

			} else {

				System.err.println(detalle + " nada mas");
			}

		} catch (Exception e) {
//				throw new Exception(e.getMessage());

			System.err.println(" nada mas " + e.getMessage());
		}

		return res;

	}

	@Override
	public RespuestaDTO<Optional<MensajeDTO>> generarVenta(VentaDetalleDTO ventaDetalleDTO) throws Exception {
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
					System.out.println(det + " detttttttttttttttttttttttt");
					
				});
				List<DetalleVenta> list = this.iDetalleRepository.findByVentaId(venta.getId());
				double totalVenta = list.stream()
						.filter((total)-> total.getVenta().getId() == venta.getId() )
						.mapToDouble((sub)-> sub.getSubtotalDetalle())
						.sum();
				venta.setTotalVenta(totalVenta);
				Venta ventaTotal =  this.iVentaRepository.save(venta);
				
				res.setCode("200 OK");
				res.setCodeValue(200);
				res.setMensaje("Venta de productos");
				res.setT(Optional.of(new MensajeDTO("Se agregó correctamente la venta")));
	
			}
				
		} catch (Exception e) {
//				throw new Exception(e.getMessage());

			System.err.println(" nada mas " + e.getMessage());
			
			res.setCode("200 OK");
			res.setCodeValue(500);
			res.setMensaje("Errar del lado de servidor");
			res.setT(Optional.of(new MensajeDTO("Los datos de la venta son incorrectos")));
			return res;
			
		}
		return res;
	}

}
