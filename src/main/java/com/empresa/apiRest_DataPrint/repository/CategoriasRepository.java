package com.empresa.apiRest_DataPrint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.apiRest_DataPrint.model.Categorias;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
	
	@Query("select c from Categorias c  where c.idcategorias=?1")
	public Categorias findByIdcategorias(Long id);
	

}
