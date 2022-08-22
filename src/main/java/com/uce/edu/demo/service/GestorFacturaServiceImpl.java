package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.IDetalleRepository;
import com.uce.edu.demo.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.Detalle;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.FacturaElectronica;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class GestorFacturaServiceImpl implements IGestorFacturaService{
	@Autowired
	private IProductoRepository productoRepo;

	@Autowired
	private IClienteRepository clienteRepo;

	@Autowired
	private IFacturaElectronicaRepository facturaElectronicaRepo;

	@Autowired
	private IFacturaRepository facturaRepo;

	@Autowired
	private IDetalleRepository detalleRepo;
	
	@Override
	@Transactional(value =TxType.REQUIRED)
	public void generarFactura(String cedula, String nroFactura, List<String> codigoBarras) {
		// TODO Auto-generated method stub
		
		

			Factura factura = new Factura();
			factura.setFecha(LocalDateTime.now());
			factura.setNumero(nroFactura);

			Cliente cliente= this.clienteRepo.buscar(cedula);

			factura.setCliente(cliente);

			this.facturaRepo.insertar(factura);


			BigDecimal total=new BigDecimal(0);

			Integer nItems=0;

			for(String p: codigoBarras) {

				Producto producto= this.productoRepo.buscar(p);
				producto.setStock(producto.getStock()-1);
				this.productoRepo.actualizar(producto);
				if(producto.getStock()<0) {
					throw new RuntimeException();
				}

				total= producto.getPrecio().add(total);

				Detalle detalle =new Detalle();

				detalle.setCantidad(1);
				detalle.setProducto(producto);
				detalle.setFactura(factura);
			    detalle.setSubtotal(producto.getPrecio().multiply(new BigDecimal(detalle.getCantidad())));
			    this.detalleRepo.insertar(detalle);
				nItems++;
			}


			FacturaElectronica fElectronica =new FacturaElectronica();
			fElectronica.setNumero(nroFactura);
			fElectronica.setMonto(total);
			fElectronica.setFechaCreacion(LocalDateTime.now());
			fElectronica.setItems(nItems);
			this.facturaElectronicaRepo.insertar(fElectronica);


		}
	}


