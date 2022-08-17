package com.empresa.apiRest_DataPrint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.apiRest_DataPrint.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

	@Query("select p from Producto p  where p.idProductoPro=?1")
	public Producto findByIdProductoPro(Long id);
	
	 @Query("select p from Producto p where p.nombrePro like %?1")
	 public Producto findByNombre(String nombre); 
}
