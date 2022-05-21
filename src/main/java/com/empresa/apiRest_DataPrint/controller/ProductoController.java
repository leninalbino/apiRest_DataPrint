package com.empresa.apiRest_DataPrint.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import com.empresa.apiRest_DataPrint.model.Producto;
import com.empresa.apiRest_DataPrint.service.ProductoService;

@RestController
@RequestMapping("/rest/v1/producto")
public class ProductoController {
	Logger logger = LoggerFactory.getLogger(ProductoController.class);
	@Autowired
	private ProductoService productoSer;
	
	@GetMapping("/p/{id}")
	public ResponseEntity<Producto>buscarProductoId(@PathVariable("id") Long id){
		Producto p = productoSer.buscarProductoId(id);
		logger.info("Lista de Producto por Id"+p.getIdProductoPro());
		return ResponseEntity.ok().body(p);
		
	}
	@GetMapping("/listProducts")
	public ResponseEntity<List<Producto>>ListFindAllProduct(){
		//List<Producto> p = productoSer.ListarProductos();
		return new ResponseEntity<List<Producto>>(productoSer.ListarProductos(), HttpStatus.CREATED);
		
	}
	
	 @PostMapping("/agregarProducto")
	    public ResponseEntity<?> agregarProducto(@RequestParam("imageProp") String imageProp,
	                                             @RequestParam("nombrePro") String nombrePro,
	                                             @RequestParam("estadoPro") Boolean estadoPro,
	                                             @RequestParam("categoria_id") Long categoria_id){

	           		Producto producto =productoSer.agregarProducto(imageProp, nombrePro, estadoPro, categoria_id);
	        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
	    }
	
	
	
}
