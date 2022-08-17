package com.empresa.apiRest_DataPrint.repository;

import com.empresa.apiRest_DataPrint.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentasRepository extends JpaRepository<Ventas,Long> {

}
