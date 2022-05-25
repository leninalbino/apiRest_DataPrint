package com.empresa.apiRest_DataPrint.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		Caracteristicas c= caracterizticasService.buscarCaracteristicaId(id);
		logger.info("Lista de Caracterizticas por Id" + c.getIdCaracteristica());
		return ResponseEntity.ok().body(c);
	}

}
