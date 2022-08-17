package com.empresa.apiRest_DataPrint.WebSecurityConfigurer;

import com.empresa.apiRest_DataPrint.model.Usuarios;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private Usuarios usuarios;

    public MyUserDetails(Usuarios usuarios){
        this.usuarios = usuarios;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return usuarios.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRol()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return usuarios.getClave();
    }

    @Override
    public String getUsername() {
        return usuarios.getCorreo();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return usuarios.getEnable();
    }

    public String nombreCompleto(){
        return usuarios.getNombre() + " "+ usuarios.getApellido();
    }
}
