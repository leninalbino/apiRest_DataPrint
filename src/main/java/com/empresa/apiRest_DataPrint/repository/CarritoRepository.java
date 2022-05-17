package com.empresa.apiRest_DataPrint.repository;

import com.empresa.apiRest_DataPrint.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepository extends JpaRepository <Carrito,Long> {
}
