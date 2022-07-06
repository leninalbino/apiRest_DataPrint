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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.empresa.apiRest_DataPrint.model.Usuarios;
import com.empresa.apiRest_DataPrint.service.UsuariosService;

@RestController
@RequestMapping("/rest/v1/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
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

	@Autowired
	private AuthenticationManager authenticationManager;
	@PostMapping("/crearToken")
	public ResponseEntity<?> crearToken(@RequestBody UsuarioRequestDTO dto){

		UserDetails userDetails = serviceUser.loadUserByUsername(dto.getCorreo());
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(dto.getCorreo(), dto.getClave()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return ResponseEntity.ok(new UsuarioResponseDTO(util.generateToken(userDetails.getUsername())));
	}


}
