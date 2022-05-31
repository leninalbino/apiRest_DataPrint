package com.empresa.apiRest_DataPrint.service;



import java.util.List;
import java.util.Optional;

import com.empresa.apiRest_DataPrint.model.Clientes;

public interface ClientesService  {
	
	public List<Clientes> ListarClientes();
	
	public Clientes buscarClienteId(Long id);
	
	public Clientes ActualizarCliente(Clientes cliente);
	
	public Clientes  registrarCliente(Clientes cliente);
	
	public Optional eliminarCliente(Long id);
	
	public Clientes buscarByDni(String dni);
	

}
