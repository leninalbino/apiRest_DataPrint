package com.empresa.apiRest_DataPrint.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;


import com.empresa.apiRest_DataPrint.model.Caracteristicas;

public interface CaracteristicaService {
	
	
	public List<Caracteristicas> ListarCaracterizticas();
	
	public Caracteristicas buscarCaracteristicaId(Long id);
	
	public Caracteristicas  registrarCaracterizticas(String descriCaract ,Integer cantidCaract,Double precioCaract, Long producto);
	
	public Optional eliminarCaracterizticas(Long id);
	
	
}
