package com.empresa.apiRest_DataPrint.service;

import java.util.List;
import java.util.Optional;

import com.empresa.apiRest_DataPrint.model.Empleado;

public interface EmpleadoService {
	
	public List<Empleado> listarEmpleado();
	
	public Empleado buscarEmpleadoId(Long id);
	
	public Empleado actualizarEmpleado(Empleado empleado);
	
	public Empleado registrarEmpleado(Empleado empleado);
	
	public Optional eliminarEmpleado(Long id);
	
	public Empleado buscarByDni(String dni);

}
