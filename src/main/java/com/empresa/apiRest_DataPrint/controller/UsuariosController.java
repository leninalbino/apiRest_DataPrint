package com.empresa.apiRest_DataPrint.controller;

import java.util.List;

import com.empresa.apiRest_DataPrint.DTO.UsuarioRequestDTO;
import com.empresa.apiRest_DataPrint.DTO.UsuarioResponseDTO;
import com.empresa.apiRest_DataPrint.WebSecurityConfigurer.JwtUtil;
import com.empresa.apiRest_DataPrint.WebSecurityConfigurer.UsuarioDetailService;
import com.empresa.apiRest_DataPrint.model.AuthToken;
import com.empresa.apiRest_DataPrint.model.LoginUsuario;
import com.empresa.apiRest_DataPrint.model.UsuariosDto;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import com.empresa.apiRest_DataPrint.model.Usuarios;
import com.empresa.apiRest_DataPrint.service.UsuariosService;

@RestController
@CrossOrigin(origins ={"http://localhost:4200","http://localhost:8086"} )
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
	//***********************************************************************************************************

	@Autowired
	private JwtUtil util;
	@Autowired
	private UsuarioDetailService serviceUser;

	@PostMapping("/crearToken")
	public ResponseEntity<?> crearToken(@RequestBody UsuarioRequestDTO dto){

		UserDetails userDetails = serviceUser.loadUserByUsername(dto.getCorreo());
		return ResponseEntity.ok(new UsuarioResponseDTO(util.generateToken(userDetails.getUsername())));
	}


}
