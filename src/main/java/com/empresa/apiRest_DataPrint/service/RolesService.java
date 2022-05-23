package com.empresa.apiRest_DataPrint.service;

import java.util.List;

import com.empresa.apiRest_DataPrint.model.Roles;

public interface RolesService {
	List<Roles> listarRoles();

	Roles registrarRoles(Roles roles);

	Roles editarRoles(Roles roles);
}
