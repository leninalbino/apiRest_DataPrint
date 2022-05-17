package com.empresa.apiRest_DataPrint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.apiRest_DataPrint.model.Producto;
import com.empresa.apiRest_DataPrint.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	@Autowired
	private ProductoRepository productoRepo;
	@Override
	public List<Producto> ListarProductos() {
		// TODO Auto-generated method stub
		return productoRepo.findAll();
	}

	@Override
	public void guardarProducto(Producto producto) {
		// TODO Auto-generated method stub
		productoRepo.save(producto);
	}

	@Override
	public void ActualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		productoRepo.save(producto);
	}

	@Override
	public Producto buscarProductoId(Long id) {
		
		return productoRepo.findByIdProductoPro(id);
	}
	 
}
