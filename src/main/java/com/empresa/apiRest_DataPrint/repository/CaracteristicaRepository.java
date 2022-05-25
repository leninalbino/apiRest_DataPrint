package com.empresa.apiRest_DataPrint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.apiRest_DataPrint.model.Caracteristicas;

public interface CaracteristicaRepository  extends JpaRepository<Caracteristicas, Long>{
	
	@Query("select c from Caracteristicas c  where c.idCaracteristica=?1")
	public Caracteristicas findByIdCaracterizticas(Long id);

}
