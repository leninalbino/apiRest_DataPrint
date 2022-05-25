package com.empresa.apiRest_DataPrint.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.empresa.apiRest_DataPrint.model.Clientes;

public interface ClientesService  {
	
	public List<Clientes> ListarClientes();
	
	public Clientes buscarClienteId(Long id);
	
	void ActualizarCliente(Clientes cliente);
	
	public Clientes  registrarCliente(String nombre ,String apellido,String telefono , Date fecrea,  String direcc, Long usuario);
	
	public Optional eliminarCliente(Long id);
	

}
