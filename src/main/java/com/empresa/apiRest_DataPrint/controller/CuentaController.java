package com.empresa.apiRest_DataPrint.controller;

import com.empresa.apiRest_DataPrint.model.Usuarios;
import com.empresa.apiRest_DataPrint.repository.UsuariosRepository;
import com.empresa.apiRest_DataPrint.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @PostMapping("/registrar")
    public ResponseEntity <?> registrarCuenta(@RequestBody Usuarios usuarios)throws MessagingException, UnsupportedEncodingException {
        Map<String, Object> response = new HashMap<>();
        if(cuentaService.registrarse(usuarios)){
            response.put("mensaje", "Se Registro el usuario correctamente");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        response.put("mensaje", "Fallo al registrar el usuario");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @PutMapping("/validarCodigoVerificacion/{codigo}")
    public  ResponseEntity<?>validarCodigoVerificacion(@PathVariable ("codigo") String codigo){
        Map<String, Object> response = new HashMap<>();
        Usuarios token = cuentaService.encontrarTokenVerificacion(codigo);
        //if(token.getTokenVerificacion()!=)
        if(codigo != null && token != null && token.getTokenVerificacion().equals(codigo)){
            cuentaService.verificaUsuario(codigo);
            response.put("mensaje", "Su cuenta ha sido verificada correctamente");
            return ResponseEntity.ok().body(response);
        }
       // if(codigo != null && token != null && !token.getTokenVerificacion().equals(codigo)){
            //response.put("mensaje", "Verifique bien el codigo que se envio al correo!!");
           // return ResponseEntity.badRequest().body(response);
        //}
        response.put("mensaje", "Verifique bien el codigo que se envio al correo!!");
        return ResponseEntity.badRequest().body(response);
    }
}
