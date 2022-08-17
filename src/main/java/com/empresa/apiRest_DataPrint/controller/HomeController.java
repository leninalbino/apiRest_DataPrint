package com.empresa.apiRest_DataPrint.controller;

import com.empresa.apiRest_DataPrint.model.Categorias;
import com.empresa.apiRest_DataPrint.model.Producto;
import com.empresa.apiRest_DataPrint.service.CategoriasService;
import com.empresa.apiRest_DataPrint.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class HomeController {
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriasService categoriaService;
    

 //   @GetMapping("/")
//    public ResponseEntity <List<Producto>> getCatalogue(){
//        List<Producto> productsList = productoService.ListarProductos();
//        return ResponseEntity.ok().body(productsList);
//    }
    
    @GetMapping("/")
	public ResponseEntity<List<Producto>>ListFindAllProduct(){
		return new ResponseEntity<List<Producto>>(productoService.ListarProductos(), HttpStatus.OK);
    }
    @GetMapping("/p/{id}")
    public ResponseEntity <?> findProductById(@PathVariable ("id") Long id){
        Producto producto = productoService.buscarProductoId(id);
        return ResponseEntity.ok(producto);
    }
    
//    @GetMapping("/")
//	public ResponseEntity<List<Categorias>> listarCategorias(){
//		return new ResponseEntity<List<Categorias>>(categoriaService.listarCategorias(), HttpStatus.OK);
//	}
}
