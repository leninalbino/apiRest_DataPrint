package com.empresa.apiRest_DataPrint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.apiRest_DataPrint.model.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    Roles findByRol(String rol);

}
