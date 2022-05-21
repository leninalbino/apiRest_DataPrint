package com.empresa.apiRest_DataPrint.service;

import java.util.List;


import com.empresa.apiRest_DataPrint.model.Producto;

public interface ProductoService {
	public List<Producto> ListarProductos();
	public Producto buscarProductoId(Long id); 

	void guardarProducto(Producto producto);

	void ActualizarProducto(Producto producto);
	
	public Producto  agregarProducto(String imageProp,String nombrePro,Boolean estadoPro ,Long categoria);

}
