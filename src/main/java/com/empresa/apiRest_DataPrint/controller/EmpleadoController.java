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

import com.empresa.apiRest_DataPrint.model.Empleado;
import com.empresa.apiRest_DataPrint.service.EmpleadoService;

@RestController
@RequestMapping("/rest/v1/empleado")
public class EmpleadoController {
	Logger logger = LoggerFactory.getLogger(EmpleadoController.class);
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping("/e/{id}")
	public ResponseEntity<Empleado>buscarEmpleadoId(@PathVariable("id") Long id){
		Map<String, Object> response=new HashMap<>();
		Empleado e=empleadoService.buscarEmpleadoId(id);
		if(e !=null) {
			return new ResponseEntity<Empleado>(e,HttpStatus.OK);
		}else {
			response.put("Mensaje", "Empleado no existe");
			return new ResponseEntity<Empleado>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/listarEmpleados")
	public ResponseEntity<List<Empleado>> listarEmpleado(){
		return new ResponseEntity<List<Empleado>>(empleadoService.listarEmpleado(), HttpStatus.OK);
		
	}
	@PostMapping("/registrarEmpleados")
	public ResponseEntity<?>registrarEmpleado(@RequestBody Empleado empleado){
		Map<String, Object> response= new HashMap<>();
		Empleado e=empleadoService.buscarByDni(empleado.getDniEml());
		if(e !=null) {
			response.put("Mensaje", "Ya existe empleado con este DNI...");
		}else {
			Empleado empleados=empleadoService.registrarEmpleado(empleado);
			response.put("String", "Empleado registrado correctamente ...");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	@DeleteMapping
	@RequestMapping("/eliminarEmpleado/{id}")
	public ResponseEntity<?> eliminarEmpleado(@PathVariable("id") long id){
		Map<String, Object> response= new HashMap<>();
		Empleado e=empleadoService.buscarEmpleadoId(id);
		
		if(e !=null) {
			empleadoService.eliminarEmpleado(id);
			response.put("Mensaje", "Empleado eliminado correctamente");
			return ResponseEntity.ok(response);
		}else {
			response.put("Mensaje", "Empleado no exite");
			return ResponseEntity.ok(response);
		}
	}
	
	@PutMapping("/actualizarEmpleado")
	public ResponseEntity<?> actualizarEmpleado(@RequestBody Empleado empleado){
		Map<String, Object> response= new HashMap<>();
		
		Empleado e=empleadoService.buscarByDni(empleado.getDniEml());
		Empleado emple=empleadoService.buscarEmpleadoId(empleado.getIdEmpleado());
		if(emple !=null) {
			if(e ==null) {
				empleadoService.actualizarEmpleado(empleado);
				response.put("Mensaje", "Actualizado correctamente");
			}else {
				response.put("Mensaje", "Error: El nombre del empleado ya existe");
			}
		}else {
			response.put("Mensaje", "Empleado no existe");
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
