package com.empresa.apiRest_DataPrint.service;

import java.util.List;
import java.util.Optional;

import com.empresa.apiRest_DataPrint.model.Categorias;
import com.empresa.apiRest_DataPrint.model.Producto;

public interface ProductoService {
	
	public List<Producto> ListarProductos();
	
	public Producto buscarProductoId(Long id);
	
	public Producto ActualizarProducto(Producto producto);
	
	public Producto  agregarProducto(Producto producto);
	
	public Optional eliminarProducto(Long id);
	
	public Producto buscarByNombre(String nombre);

}
