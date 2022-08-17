package com.empresa.apiRest_DataPrint.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins ={"http://localhost:4200"})

public class CategoriasController {
	Logger logger = LoggerFactory.getLogger(CategoriasController.class);
	
	@Autowired
	private CategoriasService categoriaService;
	
	
	@GetMapping(path = "/listar")
	public ResponseEntity<List<Categorias>> listarCategorias(){
		return new ResponseEntity<List<Categorias>>(categoriaService.listarCategorias(), HttpStatus.OK);
	}
	@GetMapping
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<Categorias>buscarCategoriaId(@PathVariable("id") Long id){
		
		Map<String, Object> response= new HashMap<>();
		Categorias c = categoriaService.buscarCategoriasId(id);
		if (c != null) {
			return new ResponseEntity<Categorias>(c, HttpStatus.OK);
		}else {
			response.put("Mensaje", "Categoria no existe");
			return new ResponseEntity<Categorias>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Categorias categoria){
		Map<String, Object> response= new HashMap<String, Object>();
		Categorias c=categoriaService.buscarByNombre(categoria.getNombreCate());
		if(c != null) {
			response.put("Mensaje", "Nombre categoria ya existe");
		}else {
			Categorias categorias=categoriaService.agregarCategorias(categoria);
			response.put("Mensaje", "Registrado correctamento");
		categoriaService.agregarCategorias(categoria);
		}
		return  ResponseEntity.status(HttpStatus.CREATED).body(response);	
	}
	@PutMapping("/actualizarCategoria")
    public ResponseEntity<?>actualizarCategoria(@RequestBody Categorias categoria){
		Categorias cate=categoriaService.obtenerCategoriaId(categoria.getIdcategorias());
		Map<String, Object> response=new HashMap<>();
		if(cate!=null) {
			categoriaService.editarCategorias(categoria);
			response.put("Mensaje", "Categoria actualizado correctamente"); 
		}else {
			response.put("Mensaje", "Categoria no existe");		
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
    }
	@DeleteMapping(path ="/eliminar/{id}")
	public boolean eliminar(@PathVariable("id") Long id) {
		return categoriaService.eliminarCategorias(id);
	}
}