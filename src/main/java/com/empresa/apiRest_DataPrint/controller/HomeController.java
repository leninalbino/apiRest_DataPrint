package com.empresa.apiRest_DataPrint.controller;

import com.empresa.apiRest_DataPrint.model.Producto;
import com.empresa.apiRest_DataPrint.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public ResponseEntity <List<Producto>> getCatalogue(){
        List<Producto> productsList = productoService.ListarProductos();
        return ResponseEntity.ok().body(productsList);
    }
}
