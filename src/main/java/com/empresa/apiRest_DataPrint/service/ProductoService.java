package com.empresa.apiRest_DataPrint.service;

import java.util.List;
import com.empresa.apiRest_DataPrint.model.Producto;

public interface ProductoService {
	public List<Producto> ListarProductos();

	void guardarProducto(Producto producto);

	void ActualizarProducto(Producto producto);

}
