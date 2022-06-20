package com.empresa.apiRest_DataPrint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.apiRest_DataPrint.model.Caracteristicas;
import com.empresa.apiRest_DataPrint.model.Producto;

public interface CaracteristicaRepository  extends JpaRepository<Caracteristicas, Long>{
	
	@Query("select c from Caracteristicas c  where c.idCaracteristica=?1")
	public Caracteristicas findByIdCaracterizticas(Long id);
	
	@Query("select c from Caracteristicas c where c.descriCaract like %?1")
	 public Caracteristicas findByNombre(String nombre); 

}
