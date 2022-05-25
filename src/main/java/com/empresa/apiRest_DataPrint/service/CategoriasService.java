package com.empresa.apiRest_DataPrint.service;

import java.util.List;
import java.util.Optional;

import com.empresa.apiRest_DataPrint.model.Categorias;

public interface CategoriasService {
	
public void agregarCategorias(Categorias categoria);
	
	public void editarCategorias(Categorias categoria);
	
	public Optional eliminarCategorias(Long id);
	
	public List<Categorias> listarCategorias();
	
	public Categorias buscarCategoriasId(Long id);
	
	public Categorias buscarByNombre(String nombre);
	
}
