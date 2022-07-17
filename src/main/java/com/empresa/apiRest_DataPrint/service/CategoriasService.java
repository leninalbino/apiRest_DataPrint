package com.empresa.apiRest_DataPrint.service;

import java.util.List;
import java.util.Optional;

import com.empresa.apiRest_DataPrint.model.Categorias;

public interface CategoriasService {
	
	public Categorias agregarCategorias(Categorias categoria);
	
	public Categorias editarCategorias(Categorias categoria);
	
	//public Optional<Categorias> eliminarCategorias(Long id);
	boolean eliminarCategorias(Long id);
	
	public List<Categorias> listarCategorias();
	
	public Categorias buscarCategoriasId(Long id);
	
	public Categorias buscarByNombre(String nombre);
	
}
