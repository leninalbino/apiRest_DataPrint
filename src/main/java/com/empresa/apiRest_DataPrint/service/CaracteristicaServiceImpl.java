package com.empresa.apiRest_DataPrint.service;

import com.empresa.apiRest_DataPrint.model.Caracteristicas;
import com.empresa.apiRest_DataPrint.model.Producto;
import com.empresa.apiRest_DataPrint.repository.CaracteristicaRepository;
import com.empresa.apiRest_DataPrint.repository.ProductoRepository;

import java.util.Date;
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
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Caracteristicas buscarCaracteristicaId(Long id) {
		return caracteristicaRepository.findByIdCaracterizticas(id);
	}




	@Override
	public Caracteristicas registrarCaracterizticas(String descriCaract, Integer cantidCaract, Double precioCaract,
			Long producto) {
		Producto productos = productoRepository.findById(producto).orElse(null);
		Caracteristicas caracterizticas= new Caracteristicas();
		
		caracterizticas.setDescriCaract(descriCaract);
		caracterizticas.setCantidCaract(cantidCaract);
		caracterizticas.setPrecioCaract(precioCaract);
		caracterizticas.setProducto(productos);
		
		caracteristicaRepository.save(caracterizticas);
		return caracterizticas;
	}

	

}
