package com.empresa.apiRest_DataPrint.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.apiRest_DataPrint.model.Categorias;
import com.empresa.apiRest_DataPrint.service.CategoriasService;

@RestController
@RequestMapping("/rest/v1/categoria")
public class CategoriasController {
	Logger logger = LoggerFactory.getLogger(CategoriasController.class);
	
	@Autowired
	private CategoriasService categoriaService;
	
	@GetMapping
	@RequestMapping(path = "/listar")
	public ResponseEntity<List<Categorias>> listarCategorias(){
		return new ResponseEntity<List<Categorias>>(categoriaService.listarCategorias(), HttpStatus.OK);
	}
	@GetMapping
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<Categorias>buscarCategoriaId(@PathVariable("id") Long id){
		Map<String, Object> response = new HashMap<>();
		
		Categorias c = categoriaService.buscarCategoriasId(id);
		logger.info("Lista de Categoria por Id"+c.getIdcategorias());
		return ResponseEntity.ok().body(c);
		
	}
	
	@PostMapping
	@RequestMapping(path = "/agregar")
	public ResponseEntity<?> agregar(@RequestBody Categorias categoria){
		Map<String, Object> response= new HashMap<String, Object>();
		Categorias cat ;
		cat = categoriaService.buscarByNombre(categoria.getNombreCate());
		if(cat != null) {
			response.put("Mensaje", "Nombre categoria ya existe ..");
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
			//return  ResponseEntity.ok(response);
			
		}else {
			response.put("Mensaje", "Registrado correctamento");
		categoriaService.agregarCategorias(categoria);

		}
		return  ResponseEntity.ok(response);
			
	}
	
	@PutMapping
	@RequestMapping("actualizarCategoria")
    public ResponseEntity<Void>actualizarCategoria(@RequestBody Categorias categoria){
		Categorias p = categoriaService.buscarCategoriasId(categoria.getIdcategorias());
		
		if (p != null) {
			categoriaService.editarCategorias(categoria);;
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
    }
	
	@DeleteMapping
	@RequestMapping(path = "/eliminar/{id}")
	public ResponseEntity<?> eliminarCategorias(@PathVariable("id") Long id){
		
		Map<String, Object> response = new HashMap<>();
		 
		 Categorias c = categoriaService.buscarCategoriasId(id);
		 
		 if(c !=null) {
			 categoriaService.eliminarCategorias(id);
			 response.put("Mensaje", "Categoria eliminado correctamente");
			 return ResponseEntity.ok(response);	 
		 }else {
			 response.put("Mensaje", "Categoria no existe");
			 return ResponseEntity.ok(response); 
		 } 
	}

}
