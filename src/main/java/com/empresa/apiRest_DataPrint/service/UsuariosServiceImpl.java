package com.empresa.apiRest_DataPrint.service;

import java.util.*;
import java.util.stream.Collectors;

import com.empresa.apiRest_DataPrint.WebSecurityConfigurer.UsuarioDetailService;
import com.empresa.apiRest_DataPrint.model.Roles;

import com.empresa.apiRest_DataPrint.repository.RolesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.empresa.apiRest_DataPrint.model.Usuarios;
import com.empresa.apiRest_DataPrint.repository.UsuariosRepository;
import org.springframework.transaction.annotation.Transactional;

@Service(value="userService")
public class UsuariosServiceImpl implements UsuariosService {
	@Autowired
	private UsuariosRepository repository;

	@Autowired
	private RolesService rolesService;



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
		return repository.findAllByCorreo(correo);
	}


	//*************************************************************************************************

/*

	private Logger logger= LoggerFactory.getLogger(UsuarioDetailService.class);
	@Autowired
	private UsuariosRepository usuariosRepository;
	@Autowired
	private RolesRepository rolesRepository;
	@Override
	@Transactional(readOnly = true)
	@Primary
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
		Usuarios usuarios = usuariosRepository.findByCorreo(correo);
		if (usuarios == null) {
			logger.error("Error en el loggin: No existe el usuario '" + correo + "' en el sistema!!");
			throw new UsernameNotFoundException("Error en el loggin: No existe el usuario '" + correo + "' en el sistema!!");
		}
		List<GrantedAuthority> authorities = usuarios.getRoles()
				.stream()
				.map(roles -> new SimpleGrantedAuthority(roles.getRol()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		return new User(usuarios.getCorreo(),
				usuarios.getClave(),
				usuarios.getEnable(),
				true,
				true,
				true, authorities);
	}

 */
}
