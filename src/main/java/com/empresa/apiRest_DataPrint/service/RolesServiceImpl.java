package com.empresa.apiRest_DataPrint.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empresa.apiRest_DataPrint.model.Roles;
import com.empresa.apiRest_DataPrint.repository.RolesRepository;

@Service
public class RolesServiceImpl implements RolesService {
	RolesRepository repository;

	@Override
	public List<Roles> listarRoles() {
		return repository.findAll();
	}

	@Override
	public Roles registrarRoles(Roles roles) {
		return repository.save(roles);
	}

	@Override
	public Roles editarRoles(Roles roles) {
		return repository.save(roles);
	}

	@Override
	public Roles findByRol(String rol) {
		Roles roles = repository.findByRol(rol);
		return roles;
	}

}
