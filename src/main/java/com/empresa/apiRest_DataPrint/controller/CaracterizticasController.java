package com.empresa.apiRest_DataPrint.controller;

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

import com.empresa.apiRest_DataPrint.model.Caracteristicas;
import com.empresa.apiRest_DataPrint.service.CaracteristicaService;



@RestController
@RequestMapping("/rest/v1/caracterizticas")
public class CaracterizticasController {
	
	Logger logger= LoggerFactory.getLogger(ClientesController.class);
	
	@Autowired
	private CaracteristicaService caracterizticasService;
	
	@GetMapping
	@RequestMapping("/listarCaracterizticas")
	public ResponseEntity<List<Caracteristicas>> ListFindAllCaracterizticas(){
		return new ResponseEntity<List<Caracteristicas>>(caracterizticasService.ListarCaracterizticas(),HttpStatus.OK);
		
	}
	
	@GetMapping("listarCaracterizticas/{id}")
	public ResponseEntity<Caracteristicas> buscarCaracterizticasId(@PathVariable("id") Long id){
		Map<String, Object> response=new HashMap<>();
		Caracteristicas c =caracterizticasService.buscarCaracteristicaId(id);
		if(c !=null) {
			return new ResponseEntity<Caracteristicas>(c,HttpStatus.OK);
		}else {
			response.put("Mensaje", "Caracteriztica no existe");
			return new ResponseEntity<Caracteristicas>(HttpStatus.NOT_FOUND);
		}


	}
	@PostMapping("/registrarCaracterizticas")
	public ResponseEntity<?> registrarCaracterizticas(@RequestBody Caracteristicas caracterizticas){
		Map<String, Object> response= new HashMap<>();
		Caracteristicas c=caracterizticasService.buscarByNombre(caracterizticas.getDescriCaract());
		
		if(c != null) {
			response.put("Mensaje", "Ya existe caracteriztica");
		}else {
			Caracteristicas caracteriztica= caracterizticasService.registrarCaracterizticas(caracterizticas);
			response.put("Mensaje", "Caracteriztica registrado correctamente");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/actualizarCaracterizticas")
	public ResponseEntity<?> actualizarCaracterizticas(@RequestBody Caracteristicas caracterizticas){
		Map<String, Object> response= new HashMap<>();
		
		Caracteristicas c= caracterizticasService.buscarByNombre(caracterizticas.getDescriCaract());
		Caracteristicas cr = caracterizticasService.buscarCaracteristicaId(caracterizticas.getIdCaracteristica());
		if(cr !=null) {
			if(c ==null) {
				caracterizticasService.actualizarCaracterizticas(caracterizticas);
				response.put("Mensaje", "Actualizado correctamente");
			}else {
				response.put("Mensaje", "Error: La descripcion del producto ya existe");
			}
		}else {
			response.put("Mensaje", "Caracteriztica no existe");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	@DeleteMapping("/eliminarCaracteriztica/{id}")
	public ResponseEntity<?> eliminarCaracteriztica(@PathVariable("id") Long id){
		Map<String, Object> response = new HashMap<>();
		
		Caracteristicas c= caracterizticasService.buscarCaracteristicaId(id);
		
		if(c != null) {
			caracterizticasService.eliminarCaracterizticas(id);
			response.put("Mensaje", "Caracteriztica eliminado correctamente");
			return ResponseEntity.ok(response);
		}else{
			response.put("Mensaje", "Caracteriztica no existe");
			return ResponseEntity.ok(response);
		}
	}
	

}





















