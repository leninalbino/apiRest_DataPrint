package com.empresa.apiRest_DataPrint.service;


import com.empresa.apiRest_DataPrint.model.Caracteristicas;

public interface CaracteristicaService {

	public Caracteristicas buscarCaracteristicaId(Long id);
	public void eliminarCaracteristica(Long id);
	
}
