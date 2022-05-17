package com.empresa.apiRest_DataPrint.controller;

import com.empresa.apiRest_DataPrint.model.Carrito;
import com.empresa.apiRest_DataPrint.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/rest/v1/carrito")
public class CarritoController {
    @Autowired
    private CarritoService carritoService;

    @PostMapping("/agregarCarrito")
    public ResponseEntity<?> agregarCarrito(@RequestParam ("caracteristica_id") Long caracteristica_id,
                                            @RequestParam("usuario_id") Long usuario_id,
                                            @RequestParam ("cantidad") Integer cantidad){

            Carrito carrito =carritoService.agregarCarrito(cantidad,caracteristica_id,usuario_id);
        return ResponseEntity.status(HttpStatus.CREATED).body(carrito);
    }
}
