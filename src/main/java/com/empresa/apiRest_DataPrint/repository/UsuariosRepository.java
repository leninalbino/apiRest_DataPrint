package com.empresa.apiRest_DataPrint.repository;

import java.util.List;
import java.util.Optional;

import com.empresa.apiRest_DataPrint.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.apiRest_DataPrint.model.Usuarios;
import org.springframework.transaction.annotation.Transactional;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
	@Query("select u from Usuarios u where u.correo like %?1%")
	List<Usuarios> findAllByCorreo(String correo);

	//@Query("select u from Usuarios u where u.nombre like %?1%")
	//List<Usuarios> findByNombre(String nombre);
	Usuarios findByCorreo(String correo);
	//findByDistinctCorreo
	//findDistinctByCorreo

	@Transactional
	@Modifying
	@Query("update Usuarios u set u.enable=true, u.tokenVerificacion=null where u.tokenVerificacion=:tokenVerificacion")
	void findByTokenVerificacion(@Param("tokenVerificacion") String tokenVerificacion);

	@Query("select u from Usuarios u where u.tokenVerificacion = :tokenVerificacion")
	Usuarios encontrarTokenVerificacion(@Param("tokenVerificacion") String tokenVerificacion);

}
