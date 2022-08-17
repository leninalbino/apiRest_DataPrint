package com.empresa.apiRest_DataPrint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.empresa.apiRest_DataPrint.model.Empleado;
import com.empresa.apiRest_DataPrint.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<Empleado> listarEmpleado() {
		return empleadoRepository.findAll();
	}

	@Override
	public Empleado buscarEmpleadoId(Long id) {
		return empleadoRepository.findByIdEmpleado(id);
	}

	@Override
	public Empleado actualizarEmpleado(Empleado empleado) {
		return empleadoRepository.saveAndFlush(empleado);
	}

	@Override
	public Empleado registrarEmpleado(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

//	@Override
//	public Optional eliminarEmpleado(Long id) {
//		List<Empleado> empleados=empleadoRepository.findAll();
//		if(id !=null) {
//			empleados.stream().filter(item ->(item.getIdEmpleado() ==id)).findFirst();
//			empleadoRepository.deleteById(id);
//		}
//		return null;
//	}

	@Override
	public Empleado buscarByDni(String dni) {
		return empleadoRepository.findByDni(dni);
	}

	@Override
	public boolean eliminarEmpleado(Long id) {
		Optional<Empleado> _c=empleadoRepository.findById(id);
		if(_c!=null) {
			empleadoRepository.delete(_c.get());
			return true;
		}
		return false;
	}

	@Override
	public Empleado obtenerEmpleadoId(Long id) {
		return empleadoRepository.findByIdEmpleado(id);
	}

}
