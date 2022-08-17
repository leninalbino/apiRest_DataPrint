package com.empresa.apiRest_DataPrint.service;

import java.util.List;

import com.empresa.apiRest_DataPrint.model.Proveedor;

public interface ProveedorService {
	
	public List<Proveedor> listarProveedores();
	
	public Proveedor buscarProveedorId(Long id);
	
	public Proveedor agregarProveedor(Proveedor proveedor);
	
	public Proveedor actualizarProveedor(Proveedor proveedor);
	
	boolean eliminarProveedores(Long id);
	
	public Proveedor buscarByNombre(String nombre);
	
	public Proveedor obtenerProveeorId(Long id);

}
