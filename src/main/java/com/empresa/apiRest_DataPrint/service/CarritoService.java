package com.empresa.apiRest_DataPrint.service;

import com.empresa.apiRest_DataPrint.model.Carrito;

import java.util.List;
import java.util.Optional;

public interface CarritoService {

    public Carrito  agregarCarrito(Integer cantidad, Long caracteristica, Long usuario);
    public List<Carrito> listarCarrito(Long idUsuario, Long idCaracteristica);
    public Optional eliminarItemCarrito(Long id);
    public Carrito actualizarItemCarrito(Long cantidad, Long id);

}
