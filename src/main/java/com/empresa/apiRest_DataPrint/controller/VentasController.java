package com.empresa.apiRest_DataPrint.controller;

import com.empresa.apiRest_DataPrint.model.Carrito;
import com.empresa.apiRest_DataPrint.model.DetalleVenta;
import com.empresa.apiRest_DataPrint.model.Usuarios;
import com.empresa.apiRest_DataPrint.model.Ventas;
import com.empresa.apiRest_DataPrint.service.CarritoService;
import com.empresa.apiRest_DataPrint.service.DetalleVentaService;
import com.empresa.apiRest_DataPrint.service.UsuariosService;
import com.empresa.apiRest_DataPrint.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/rest/v1/ventas")
public class VentasController {

    @Autowired
    private VentasService ventasService;

    @Autowired
    private CarritoService carritoService;

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private DetalleVentaService detalleVentaService;

    @PostMapping("/create")
    public ResponseEntity<?> create (Principal principal){

        Ventas ventas = new Ventas();
        Usuarios usuarios = usuariosService.encontrarCorrero(principal.getName());
        List<Carrito> carritos= carritoService.encontrarItemUsuario(usuarios.getIdusuarios());
        ventas.setUsuarios(usuarios);
        carritos.forEach(carrito -> {
            Double total = Double.valueOf(0);
            total += carrito.getCaracteristica().getPrecioCaract() *
                        carrito.getCantidad();
            DetalleVenta detalleVenta = new DetalleVenta();
            ventas.setPrecioTotal(total);
            detalleVenta.setVenta(ventas);
            detalleVenta.setCaracteristica(carrito.getCaracteristica());
            detalleVenta.setPrecio(carrito.getCaracteristica().getPrecioCaract());
            detalleVenta.setCantida(carrito.getCantidad());
            ventas.agregarDetalleVenta(detalleVenta);
        });
        ventasService.create(ventas);
        return ResponseEntity.status(HttpStatus.CREATED).body(ventas);
    }

}
