package com.empresa.apiRest_DataPrint.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.apiRest_DataPrint.model.Clientes;
import com.empresa.apiRest_DataPrint.service.ClientesService;

@RestController
@RequestMapping("/rest/v1/cliente")
public class ClientesController {
	Logger logger = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private ClientesService clienteService;
	
	@GetMapping
	@RequestMapping("/listarClientes")
	public ResponseEntity<List<Clientes>> ListFindAllClientes(){
		return new ResponseEntity<List<Clientes>>(clienteService.ListarClientes(),HttpStatus.OK);
	}
	@GetMapping("/listarClientes/{id}")
	public ResponseEntity<Clientes>buscarClientesId(@PathVariable("id") Long id){
		Clientes c = clienteService.buscarClienteId(id);
		logger.info("Lista de Producto por Id"+c.getIdcliente());
		return ResponseEntity.ok().body(c);
		
	}
	@PostMapping
	@RequestMapping("/registrarClientes")
	public ResponseEntity<?> registrarClientes(@RequestParam("nombre") String nombre,
											   @RequestParam("apellido") String apellido,
											   @RequestParam("telefono") String telefono,
											   //@RequestParam("fecrea") Date fecrea,
											   @RequestParam("direcc") String direcc,
											   @RequestParam("usuario_id") Long usuario_id){
		Clientes clientes = clienteService.registrarCliente(nombre, apellido, telefono, direcc, usuario_id);
		return ResponseEntity.status(HttpStatus.CREATED).body(clientes);
		
	}
	
	@DeleteMapping
	@RequestMapping("/eliminarCliente/{id}")
	public ResponseEntity<?> eliminarCliente(@PathVariable("id") long id){
		Map<String, Object> response = new HashMap<>();
		Clientes c= clienteService.buscarClienteId(id);
		
		if(c !=null) {
			clienteService.eliminarCliente(id);
			response.put("Mensaje", "Cliente eliminado correctamente");
			return ResponseEntity.ok(response);
		}else {
			response.put("Mensaje", "Cliente no existe");
			return ResponseEntity.ok(response);
		}
	}
	
	

}
