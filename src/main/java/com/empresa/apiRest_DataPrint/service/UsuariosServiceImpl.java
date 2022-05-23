package com.empresa.apiRest_DataPrint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.apiRest_DataPrint.model.Usuarios;
import com.empresa.apiRest_DataPrint.repository.UsuariosRepository;

@Service
public class UsuariosServiceImpl implements UsuariosService {
	@Autowired
	UsuariosRepository repository;

	@Override
	public List<Usuarios> listarUsuarios() {
		return repository.findAll();
	}

	@Override
	public Usuarios registrarUsuarios(Usuarios usuarios) {
		return repository.save(usuarios);
	}

	@Override
	public Usuarios editarUsuarios(Usuarios usuarios) {
		return repository.save(usuarios);
	}

	@Override
	public List<Usuarios> findByCorreo(String correo) {
		return repository.findByCorreo(correo);
	}

	@Override
	public List<Usuarios> findByNombre(String nombre) {
		return repository.findByNombre(nombre);

	}

}
