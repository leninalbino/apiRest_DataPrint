package com.empresa.apiRest_DataPrint.service;

import com.empresa.apiRest_DataPrint.model.DetalleVenta;
import com.empresa.apiRest_DataPrint.repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService{

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Override
    public void create(DetalleVenta detalleVenta) {
        detalleVentaRepository.save(detalleVenta);
    }
}
