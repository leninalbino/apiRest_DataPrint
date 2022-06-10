package com.empresa.apiRest_DataPrint.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.empresa.apiRest_DataPrint.model.Usuarios;
import com.empresa.apiRest_DataPrint.service.UsuariosService;

@RestController
@CrossOrigin
@RequestMapping("/rest/v1/usuarios")
public class UsuariosController {

	@Autowired
	private UsuariosService service;

	@GetMapping("/listarUsuarios")
	public ResponseEntity<List<Usuarios>> listarUsuarios() {
		List<Usuarios> obj = service.listarUsuarios();
		return new ResponseEntity<List<Usuarios>>(obj, HttpStatus.OK);
	}

	@PostMapping("/regisrarUsuario")
	public ResponseEntity<Usuarios> registrarUsuarios(@RequestBody Usuarios usuarios) {
		Usuarios obj = service.registrarUsuarios(usuarios);
		// URI uri =
		// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdusuarios()).toUri();
		return new ResponseEntity<Usuarios>(obj, HttpStatus.OK);
		// return ResponseEntity.created(uri).build();
	}

	@PutMapping("/editarUsuario")
	public ResponseEntity<Usuarios> editarUsuarios(@RequestBody Usuarios usuarios) {
		Usuarios obj = service.editarUsuarios(usuarios);
		return new ResponseEntity<Usuarios>(obj, HttpStatus.OK);
	}

	// buscar correo
	@GetMapping("/listarCorreo/{correo}")
	public ResponseEntity<List<Usuarios>> findByCorreo(@PathVariable("correo") String correo) {
		List<Usuarios> obj = service.findByCorreo(correo);
		return ResponseEntity.ok(obj);

	}
	// buscar nombre
	@GetMapping("/listarNombre/{nombre}")
	public ResponseEntity<List<Usuarios>> findByNombre(@PathVariable("nombre") String nombre) {
		List<Usuarios> obj = service.findByNombre(nombre);
		return ResponseEntity.ok(obj);

	}
}
