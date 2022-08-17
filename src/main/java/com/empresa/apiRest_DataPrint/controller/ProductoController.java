package com.empresa.apiRest_DataPrint.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.empresa.apiRest_DataPrint.model.ImagenModel;
import com.empresa.apiRest_DataPrint.model.Producto;
import com.empresa.apiRest_DataPrint.service.ProductoService;

@RestController
@RequestMapping("/rest/v1/producto")
@CrossOrigin(origins = { "http://localhost:4200" })
public class ProductoController {
	Logger logger = LoggerFactory.getLogger(ProductoController.class);
	@Autowired
	private ProductoService productoSer;

	@GetMapping("/p/{id}")
	public ResponseEntity<Producto> buscarProductoId(@PathVariable("id") Long id) {

		Map<String, Object> response = new HashMap<>();
		Producto p = productoSer.buscarProductoId(id);
		if (p != null) {
			return new ResponseEntity<Producto>(p, HttpStatus.OK);
		} else {
			response.put("Mensaje", "Producto no existe");
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/listProducts")
	public ResponseEntity<List<Producto>> ListFindAllProduct() {
		return new ResponseEntity<List<Producto>>(productoSer.ListarProductos(), HttpStatus.OK);

	}

	/*
	 * @PostMapping(value = { "/agregarProducto" }, consumes = {
	 * MediaType.MULTIPART_FORM_DATA_VALUE })
	 * public ResponseEntity<?> agregarProducto(@RequestPart("producto") Producto
	 * producto,
	 * 
	 * @RequestPart("imageFile") MultipartFile[] file) {
	 * 
	 * try {
	 * Set<ImagenModel> images = uploadImage(file);
	 * producto.setProductImages(images);
	 * 
	 * Map<String, Object> response = new HashMap<>();
	 * Producto p = productoSer.buscarByNombre(producto.getNombrePro());
	 * System.out.println(producto);
	 * if (p != null) {
	 * response.put("Mensaje", "Ya existe producto");
	 * 
	 * } else {
	 * Producto productos = productoSer.agregarProducto(producto);
	 * response.put("Mensaje", "Producto registrado correctamente");
	 * }
	 * return ResponseEntity.status(HttpStatus.CREATED).body(response);
	 * } catch (Exception e) {
	 * System.out.println(e.getMessage());
	 * return null;
	 * }
	 * 
	 * }
	 */
	@PostMapping(value = { "/agregarProducto" }, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public Producto agregarProducto(@RequestPart("producto") Producto producto,
									@RequestPart("imageFile") MultipartFile[] file) {

		try {
			Set<ImagenModel> images = uploadImage(file);
			producto.setProductImages(images);
			return productoSer.agregarProducto(producto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public Set<ImagenModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
		Set<ImagenModel> imageModels = new HashSet<>();
		for (MultipartFile file : multipartFiles) {
			ImagenModel imageModel = new ImagenModel(
					file.getOriginalFilename(),
					file.getContentType(),
					file.getBytes());
			imageModels.add(imageModel);
		}
		return imageModels;
	}

	@DeleteMapping("/eliminarProducto/{id}")
	public ResponseEntity<?> elminarProducto(@PathVariable("id") long id) {

		Map<String, Object> response = new HashMap<>();

		Producto p = productoSer.buscarProductoId(id);

		if (p != null) {
			productoSer.eliminarProducto(id);
			response.put("Mensaje", "Producto eliminado correctamente");
			return ResponseEntity.ok(response);
		} else {
			response.put("Mensaje", "Producto no existe");
			return ResponseEntity.ok(response);
		}
	}

	@PutMapping("/actualizarProducto")
	public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto) {
		Map<String, Object> response = new HashMap<>();

		Producto p = productoSer.buscarByNombre(producto.getNombrePro());
		Producto pr = productoSer.buscarProductoId(producto.getIdProductoPro());
		if (pr != null) {
			if (p == null) {
				productoSer.ActualizarProducto(producto);
				response.put("Mensaje", "Actualizado correctamente");
			} else {
				response.put("Mensaje", "Error: El nombre del producto ya existe");
			}

		} else {
			response.put("Mensaje", "Producto no existe");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

}
