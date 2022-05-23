package com.empresa.apiRest_DataPrint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.apiRest_DataPrint.model.Roles;
import com.empresa.apiRest_DataPrint.service.RolesService;

@RestController
@RequestMapping("/rest/v1/roles")
public class RolesController {

	@Autowired
	private RolesService service;
	
	@GetMapping("/listarRoles")
	public ResponseEntity<List<Roles>> listarRoles() {
		List<Roles> obj = service.listarRoles();
		return new ResponseEntity<List<Roles>>(obj, HttpStatus.OK);
	}

	@PostMapping("/RegisrarRoles")
	public ResponseEntity<Roles> registrarRoles(@RequestBody Roles roles) {
		Roles obj = service.registrarRoles(roles);
		return new ResponseEntity<Roles>(obj, HttpStatus.OK);
	}

	@PutMapping("/RegisrarRoles")
	public ResponseEntity<Roles> editarRoles(@RequestBody Roles roles) {
		Roles obj = service.editarRoles(roles);
		return new ResponseEntity<Roles>(obj, HttpStatus.OK);
	}
}
