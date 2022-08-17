package com.empresa.apiRest_DataPrint.service;

import com.empresa.apiRest_DataPrint.model.Ventas;
import com.empresa.apiRest_DataPrint.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentasServiceImpl implements VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    @Override
    public Ventas create(Ventas ventas) {
        return  ventasRepository.save(ventas);
    }

}
