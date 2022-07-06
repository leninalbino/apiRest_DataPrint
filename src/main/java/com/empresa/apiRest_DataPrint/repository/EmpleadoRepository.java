package com.empresa.apiRest_DataPrint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.apiRest_DataPrint.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
	
	@Query("select e from Empleado e where e.idEmpleado=?1")
	public Empleado findByIdEmpleado(Long id);
	
	@Query("select e from Empleado e where e.dniEml like %?1")
	public Empleado findByDni(String dni);

}
