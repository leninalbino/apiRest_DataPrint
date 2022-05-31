package com.empresa.apiRest_DataPrint.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;


import com.empresa.apiRest_DataPrint.model.Caracteristicas;

public interface CaracteristicaService {
	
	
	public List<Caracteristicas> ListarCaracterizticas();
	
	public Caracteristicas buscarCaracteristicaId(Long id);
	
	public Caracteristicas  registrarCaracterizticas(Caracteristicas caracterizticas);
	
	public Caracteristicas actualizarCaracterizticas(Caracteristicas caracterizticas);
	
	public Optional eliminarCaracterizticas(Long id);
	
	public Caracteristicas buscarByNombre(String nombre);
	
	
}
