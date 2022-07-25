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

import com.empresa.apiRest_DataPrint.model.Proveedor;
import com.empresa.apiRest_DataPrint.service.ProveedorService;

@RestController
@RequestMapping("/rest/v1/proveedor")
@CrossOrigin(origins ={"http://localhost:4200"})
public class ProveedorController {
	Logger logger=LoggerFactory.getLogger(ProveedorController.class);
	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping("/p/{id}")
	public ResponseEntity<Proveedor>buscarProveedorId(@PathVariable("id") Long id){
		
		Map<String, Object> response=new HashMap<>();
		Proveedor p =proveedorService.buscarProveedorId(id);
		if(p !=null) {
			return new ResponseEntity<Proveedor>(p,HttpStatus.OK);
		}else {
			response.put("Mensaje", "Proveedor no existe");
			return new ResponseEntity<Proveedor>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping(path =  "/listarProveedores")
	public ResponseEntity<List<Proveedor>> ListarProveedor(){
		return new ResponseEntity<List<Proveedor>>(proveedorService.listarProveedores(),HttpStatus.OK);
	}
	
	@PostMapping("/agregarProveedor")
	public ResponseEntity<?>agregarProveedor(@RequestBody Proveedor proveedor){
		Map<String, Object> response=new HashMap<>();
		Proveedor p=proveedorService.buscarByNombre(proveedor.getNombreEmpresa());
		if(p !=null) {
			response.put("Mensaje", "Ya existe proveedor");
		}else {
			Proveedor proveedores=proveedorService.agregarProveedor(proveedor);
			response.put("Mensaje", "Proveedor registrado correctamente");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
//	@DeleteMapping("/eliminarProveedor/{id}")
//	public ResponseEntity<?> eliminarProveedor(@PathVariable("id") long id){
//		Map<String, Object> response = new HashMap<>();
//		
//		Proveedor p= proveedorService.buscarProveedorId(id);
//		if(p  !=null) {
//			proveedorService.eliminarProveedor(id);
//			response.put("Mensaje", "Proveedor eliminado correctamente");
//			return ResponseEntity.ok(response);
//		}else {
//			response.put("Mensaje", "Proveedor no existe");
//			return ResponseEntity.ok(response);
//		}
//	}
	
	@DeleteMapping("/eliminarProveedor/{id}")
	public boolean eliminar(@PathVariable("id") Long id) {
		return proveedorService.eliminarProveedores(id);
	}
	
	
	@PutMapping("/actualizarProveedor")
	public ResponseEntity<?> actualizarProveedor(@RequestBody Proveedor proveedor){
		Map<String, Object> response= new HashMap<>();
		
		Proveedor p = proveedorService.buscarByNombre(proveedor.getNombreEmpresa());
		Proveedor prove=proveedorService.buscarProveedorId(proveedor.getIdProveedor());
		if(prove !=null) {
			if(p ==null) {
			proveedorService.actualizarProveedor(proveedor);
			response.put("Mensaje", "Actualizado correctamente");
		}else {
			response.put("Mensaje", "Error: El nombre del proveedor ya existe");
		}
		 
	 }else {
		 response.put("Mensaje", "Proveedor no existe"); 
	 } 
	 return ResponseEntity.status(HttpStatus.CREATED).body(response); 
}
}



