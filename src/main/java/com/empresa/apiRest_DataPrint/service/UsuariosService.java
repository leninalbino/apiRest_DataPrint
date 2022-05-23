package com.empresa.apiRest_DataPrint.service;

import java.util.List;

import com.empresa.apiRest_DataPrint.model.Usuarios;

public interface UsuariosService {

	List<Usuarios> listarUsuarios();

	Usuarios registrarUsuarios(Usuarios usuarios);

	Usuarios editarUsuarios(Usuarios usuarios);

	List<Usuarios> findByCorreo(String correo);

	List<Usuarios> findByNombre(String nombre);

}
