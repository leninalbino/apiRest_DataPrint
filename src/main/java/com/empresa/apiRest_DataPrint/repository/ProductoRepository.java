package com.empresa.apiRest_DataPrint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.apiRest_DataPrint.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

	
}
