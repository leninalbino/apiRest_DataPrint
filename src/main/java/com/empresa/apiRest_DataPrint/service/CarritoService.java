package com.empresa.apiRest_DataPrint.service;

import com.empresa.apiRest_DataPrint.model.Carrito;

public interface CarritoService {

    public Carrito  agregarCarrito(Integer cantidad, Long caracteristica, Long usuario);

}
