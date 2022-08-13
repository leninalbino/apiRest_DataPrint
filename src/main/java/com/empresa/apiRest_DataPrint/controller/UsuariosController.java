package com.empresa.apiRest_DataPrint.controller;

import java.text.ParseException;
import java.util.List;

import com.empresa.apiRest_DataPrint.excepciones.Mensaje;
import org.springframework.validation.BindingResult;
import com.empresa.apiRest_DataPrint.DTO.UsuarioRequestDTO;
import com.empresa.apiRest_DataPrint.DTO.UsuarioResponseDTO;
import com.empresa.apiRest_DataPrint.WebSecurityConfigurer.JwtUtil;
import com.empresa.apiRest_DataPrint.WebSecurityConfigurer.UsuarioDetailService;
import com.empresa.apiRest_DataPrint.model.AuthToken;
import com.empresa.apiRest_DataPrint.model.LoginUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
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
	public ResponseEntity<AuthToken> crearToken(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						usuarioRequestDTO.getCorreo(),
						usuarioRequestDTO.getClave()
				)
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final String token = util.generateToken( authentication);
		UserDetails userDetails = (UserDetails)authentication.getPrincipal();
		AuthToken authToken = new AuthToken(token, userDetails.getUsername());
		System.out.println("00000"+ userDetails + authToken);
		return ResponseEntity.ok(authToken);
	}
	@PostMapping("/refresh")
	public ResponseEntity<UsuarioResponseDTO> refresh(@RequestBody UsuarioResponseDTO jwtDto) throws ParseException {
		String token = util.refreshToken(jwtDto);
		UsuarioResponseDTO jwt = new UsuarioResponseDTO(token);

		return new ResponseEntity(jwt, HttpStatus.OK);
	}
}
