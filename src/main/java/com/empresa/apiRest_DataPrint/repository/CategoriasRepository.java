package com.empresa.apiRest_DataPrint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.apiRest_DataPrint.model.Categorias;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
	

}
