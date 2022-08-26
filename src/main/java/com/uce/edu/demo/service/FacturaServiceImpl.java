package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.Detalle;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class FacturaServiceImpl implements IFacturaService{
	@Autowired
	private IFacturaRepository facturaRepo;
	
	@Autowired
	private IClienteRepository clienteRepo;
	
	@Autowired
	private IProductoRepository productoRepo;
	@Override
	public BigDecimal calcularTotal(Integer id) {
		// TODO Auto-generated method stub
		Factura f=this.facturaRepo.buscar(id);
		List<Detalle> productos=f.getDetalles();
		BigDecimal valorFactura=new BigDecimal(0);
		
		for(Detalle p: productos) {
			BigDecimal cantidad=new BigDecimal(p.getCantidad());
			valorFactura=valorFactura.add(cantidad).multiply(p.getPrecio());
		}
		return valorFactura;
	}
	@Override
	public Integer cantidadTotal(Integer id) {
		// TODO Auto-generated method stub
		Factura f=this.facturaRepo.buscar(id);
		List<Detalle> productos=f.getDetalles();
		Integer totalProductos=0;
		
		for(Detalle p: productos) {
			totalProductos=totalProductos+p.getCantidad();
		}
		
		return totalProductos;
	}
	@Override
	@Transactional(value=TxType.REQUIRES_NEW)
	public BigDecimal facturar(String cedula,String nroFactura,List<String>codBarras) {
		// TODO Auto-generated method stub
		Factura factura =new Factura();
		factura.setFecha(LocalDateTime.now());
		factura.setNumero(nroFactura);
		
		Cliente cliente=this.clienteRepo.buscar(cedula);
		factura.setCliente(cliente);
		this.facturaRepo.insertar(factura);
		
		BigDecimal total=new BigDecimal(0);
		
		List<Detalle>detalles=new ArrayList<>();
		for(String prod:codBarras) {
			
			Producto p=this.productoRepo.buscar(prod);
			if(p.getStock()<0) {
				throw new RuntimeException();
			}
			p.setStock(p.getStock()-1);
			this.productoRepo.actualizar(p);
			total=p.getPrecio().add(total);
			
			Detalle detalle=new Detalle();
			detalle.setCantidad(1);
			detalle.setProducto(p);
			detalle.setFactura(factura);
			detalle.setSubtotal(p.getPrecio().multiply(new BigDecimal(detalle.getCantidad())));
			detalles.add(detalle);
		}
		factura.setDetalles(detalles);
		return total;
	}

}
