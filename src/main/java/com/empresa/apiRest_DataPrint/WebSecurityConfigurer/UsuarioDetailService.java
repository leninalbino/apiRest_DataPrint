package com.empresa.apiRest_DataPrint.WebSecurityConfigurer;

import com.empresa.apiRest_DataPrint.model.Roles;
import com.empresa.apiRest_DataPrint.model.Usuarios;
import com.empresa.apiRest_DataPrint.repository.RolesRepository;
import com.empresa.apiRest_DataPrint.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioDetailService implements UserDetailsService {
    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private RolesRepository rolesRepository;
    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuarios usuarios=usuariosRepository.findByCorreo(correo);

        if(usuarios!= null){
            Roles roles = rolesRepository.findByRol(usuarios.getRoles().getRol());
            // creamos una lista de GrantedAuthority para agregar objeto de tipo GrantedAuthority
            List<GrantedAuthority> granted = new ArrayList<GrantedAuthority>();
            // este objeto recibe un atributo de tipo String y los convierte a tipo GrantedAuthority
            GrantedAuthority authority=new SimpleGrantedAuthority(usuarios.getRoles().getRol());
            // luego le añadimos a la lista
            granted.add(authority);
            return new User(usuarios.getCorreo(), usuarios.getClave(),granted);
        }else {
            throw new UsernameNotFoundException("El usuario no existe");
        }
    }
}
