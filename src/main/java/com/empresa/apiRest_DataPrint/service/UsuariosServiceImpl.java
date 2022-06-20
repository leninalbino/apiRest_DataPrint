package com.empresa.apiRest_DataPrint.service;

import java.util.*;

import com.empresa.apiRest_DataPrint.model.Roles;
import com.empresa.apiRest_DataPrint.model.UsuariosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.empresa.apiRest_DataPrint.model.Usuarios;
import com.empresa.apiRest_DataPrint.repository.UsuariosRepository;

@Service(value="userService")
public class UsuariosServiceImpl implements UserDetailsService,UsuariosService {
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



	@Override
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
		Usuarios usuarios= repository.findByCorreo(correo);
		if(usuarios == null){
			throw new UsernameNotFoundException("Invalido Correo o Clave");
		}
		return new org.springframework.security.core.userdetails.User(usuarios.getCorreo(), usuarios.getClave(), getAuthority(usuarios));
	}

	private List<SimpleGrantedAuthority> getAuthority(Usuarios usuarios) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

			authorities.add(new SimpleGrantedAuthority("ROLES_" + usuarios.getRoles().getRol()));

		return authorities;
	}
}
