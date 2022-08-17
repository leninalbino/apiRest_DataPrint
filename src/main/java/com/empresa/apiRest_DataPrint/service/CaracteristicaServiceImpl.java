package com.empresa.apiRest_DataPrint.service;

import com.empresa.apiRest_DataPrint.model.Caracteristicas;
import com.empresa.apiRest_DataPrint.model.Producto;
import com.empresa.apiRest_DataPrint.repository.CaracteristicaRepository;
import com.empresa.apiRest_DataPrint.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaracteristicaServiceImpl implements CaracteristicaService {


	@Autowired
	public CaracteristicaRepository caracteristicaRepository;
	
	@Autowired ProductoRepository productoRepository;

	@Override
	public List<Caracteristicas> ListarCaracterizticas() {
		return caracteristicaRepository.findAll();
	}
	
	@Override
	public Optional eliminarCaracterizticas(Long id) {
		List<Caracteristicas> caracterizticas = caracteristicaRepository.findAll();
		if(id !=null) {
			caracterizticas.stream().filter(item -> (item.getIdCaracteristica() == id)).findFirst();
            caracteristicaRepository.deleteById(id);
		}
		return null;
	}
	
	@Override
	public Caracteristicas buscarCaracteristicaId(Long id) {
		return caracteristicaRepository.findByIdCaracterizticas(id);
	}
	
	@Override
	public Caracteristicas registrarCaracterizticas(Caracteristicas caracterizticas) {
		//Producto productos= productoRepository.findById(caracterizticas.getProducto().getIdProductoPro()).orElse(null);
		return caracteristicaRepository.save(caracterizticas);
		
	}
	@Override
	public Caracteristicas actualizarCaracterizticas(Caracteristicas caracterizticas) {
		Producto productos = productoRepository.findById(caracterizticas.getProducto().getIdProductoPro()).orElse(null);
		return caracteristicaRepository.saveAndFlush(caracterizticas);
	}
	
	@Override
	public Caracteristicas buscarByNombre(String nombre) {
		return caracteristicaRepository.findByNombre(nombre);
	}




	

}
