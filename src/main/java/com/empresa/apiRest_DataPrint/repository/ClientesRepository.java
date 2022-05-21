package com.empresa.apiRest_DataPrint.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.empresa.apiRest_DataPrint.model.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}
