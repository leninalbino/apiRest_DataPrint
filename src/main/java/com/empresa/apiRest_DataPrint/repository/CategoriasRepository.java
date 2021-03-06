package com.empresa.apiRest_DataPrint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.apiRest_DataPrint.model.Categorias;
import com.empresa.apiRest_DataPrint.model.Producto;

import java.util.List;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
	
	@Query("select c from Categorias c  where c.idcategorias=?1")
	public Categorias findByIdcategorias(Long id);
	
	 @Query("select c from Categorias c where c.nombreCate like %?1")
	 public Categorias  findByNombre(String nombre);
	

}
