package com.empresa.apiRest_DataPrint.repository;

import java.util.List;
import com.empresa.apiRest_DataPrint.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.apiRest_DataPrint.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
	@Query("select u from Usuarios u where u.correo like %?1%")
	List<Usuarios> findByCorreo(String correo);

	@Query("select u from Usuarios u where u.nombre like %?1%")
	List<Usuarios> findByNombre(String nombre);

}
