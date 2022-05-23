package com.empresa.apiRest_DataPrint.service;

import com.empresa.apiRest_DataPrint.model.Caracteristicas;
import com.empresa.apiRest_DataPrint.repository.CaracteristicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaracteristicaServiceImpl implements CaracteristicaService {


	@Autowired
	public CaracteristicaRepository caracteristicaRepository;

	public Caracteristicas buscarCaracteristicaId(Long id) {
		return caracteristicaRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarCaracteristica(Long id) {
		// TODO Auto-generated method stub
		
	}

}
