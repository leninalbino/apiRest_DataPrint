package com.empresa.apiRest_DataPrint.service;

import java.util.List;

import com.empresa.apiRest_DataPrint.model.Empleado;
public interface EmpleadoService {
	
	public List<Empleado> listarEmpleado();
	
	public Empleado buscarEmpleadoId(Long id);
	
	public Empleado actualizarEmpleado(Empleado empleado);
	
	public Empleado registrarEmpleado(Empleado empleado);
	
	boolean eliminarEmpleado(Long id);
	
	public Empleado buscarByDni(String dni);
	
	public Empleado obtenerEmpleadoId(Long id);

}
