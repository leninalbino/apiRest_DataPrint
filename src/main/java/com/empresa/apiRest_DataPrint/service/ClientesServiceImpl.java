package com.empresa.apiRest_DataPrint.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.apiRest_DataPrint.model.Clientes;
import com.empresa.apiRest_DataPrint.model.Usuarios;
import com.empresa.apiRest_DataPrint.repository.ClientesRepository;
import com.empresa.apiRest_DataPrint.repository.UsuariosRepository;

@Service
public class ClientesServiceImpl implements ClientesService {
	@Autowired
	private ClientesRepository clientesRepository;
	
	@Autowired
	private UsuariosRepository usuariosRepository;

	@Override
	public List<Clientes> ListarClientes() {
		return clientesRepository.findAll();
		
	}

	@Override
	public Clientes buscarClienteId(Long id) {
		return clientesRepository.findByIdCliente(id);
	}

	@Override
	public Optional eliminarCliente(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clientes ActualizarCliente(Clientes cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clientes registrarCliente(Clientes cliente) {
		Clientes clientes = clientesRepository.findById(cliente.getIdcliente()).orElse(null);
		
		
		return clientesRepository.save(cliente);
	}

	

}
