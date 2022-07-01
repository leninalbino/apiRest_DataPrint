package com.empresa.apiRest_DataPrint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.apiRest_DataPrint.model.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{
	
	@Query("select p from Proveedor p where p.idProveedor=?1")
	public Proveedor findByIdProveedor(Long id);
	
	@Query("select p from Proveedor p where p.nombreEmpresa like %?1")
	public Proveedor findByNombre(String nombre);

}
