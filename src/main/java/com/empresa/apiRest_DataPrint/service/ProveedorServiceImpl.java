package com.empresa.apiRest_DataPrint.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.apiRest_DataPrint.model.Proveedor;
import com.empresa.apiRest_DataPrint.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService {
	
	@Autowired
	private ProveedorRepository proveedorRepository;

	@Override
	public List<Proveedor> listarProveedores() {
		return proveedorRepository.findAll();
	}

	@Override
	public Proveedor buscarProveedorId(Long id) {
		return proveedorRepository.findByIdProveedor(id);
	}

	@Override
	public Proveedor agregarProveedor(Proveedor proveedor) {
		return proveedorRepository.save(proveedor);
	}

	@Override
	public Proveedor actualizarProveedor(Proveedor proveedor) {
		Proveedor p= new Proveedor();
		p.setNombreEmpresa(proveedor.getNombreEmpresa());
		p.setIdProveedor(proveedor.getIdProveedor());
		p.setCorreo(proveedor.getCorreo());
		p.setTelefono(proveedor.getTelefono());
		p.setDireccion(proveedor.getDireccion());
		
		return proveedorRepository.saveAndFlush(proveedor);
	}

	@Override
	public Optional eliminarProveedor(Long id) {
		List<Proveedor> proveedores=proveedorRepository.findAll();
		if(id !=null) {
			proveedores.stream().filter(item -> (item.getIdProveedor() ==id)).findFirst();
			proveedorRepository.deleteById(id);
		}
		return null;
	}

	@Override
	public Proveedor buscarByNombre(String nombre) {
		return proveedorRepository.findByNombre(nombre);
	}

}
