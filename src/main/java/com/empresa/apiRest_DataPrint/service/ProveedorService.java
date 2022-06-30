package com.empresa.apiRest_DataPrint.service;

import java.util.List;
import java.util.Optional;

import com.empresa.apiRest_DataPrint.model.Proveedor;

public interface ProveedorService {
	
	public List<Proveedor> listarProveedores();
	
	public Proveedor buscarProveedorId(Long id);
	
	public Proveedor agregarProveedor(Proveedor proveedor);
	
	public Proveedor actualizarProveedor(Proveedor proveedor);
	
	public Optional eliminarProveedor(Long id);
	
	public Proveedor buscarByNombre(String nombre);

}
