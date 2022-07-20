package com.empresa.apiRest_DataPrint.service;

import com.empresa.apiRest_DataPrint.model.Roles;
import com.empresa.apiRest_DataPrint.model.Usuarios;
import com.empresa.apiRest_DataPrint.repository.RolesRepository;
import com.empresa.apiRest_DataPrint.repository.UsuariosRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaServiceImpl implements CuentaService{
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private EnvioCorreo envioCorreo;
    @Override
    public boolean registrarse(Usuarios usuarios) throws MessagingException, UnsupportedEncodingException {
        String token= RandomString.make(6);

        if(usuarios != null ){
            Roles roles = rolesRepository.findByRol("ROLE_CLIENTE");
            List<Roles> rolesList = Arrays.asList(roles);
            usuarios.setClave(passwordEncoder.encode(usuarios.getClave()));
            usuarios.setRoles(rolesList);
            usuarios.setTokenVerificacion(token.toUpperCase());
            usuarios.setEnable(false);
            usuarios.setFecrea(new Date());
            usuariosRepository.save(usuarios);
            envioCorreo.verificacionCorreo(usuarios);
            return true;
        }
        return false;
    }

    @Override
    public void verificaUsuario(String tokenVerificador) {
        usuariosRepository.findByTokenVerificacion(tokenVerificador);
        }

    @Override
    public Usuarios encontrarTokenVerificacion(String tokenVerificacion) {
        return usuariosRepository.encontrarTokenVerificacion(tokenVerificacion);
    }


}
