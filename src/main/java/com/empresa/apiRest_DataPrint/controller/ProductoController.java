package com.empresa.apiRest_DataPrint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.apiRest_DataPrint.service.ProductoService;

@RestController
@RequestMapping("/rest/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoSer;
	
	
	
}
