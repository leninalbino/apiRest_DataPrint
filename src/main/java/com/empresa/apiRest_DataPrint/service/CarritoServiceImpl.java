package com.empresa.apiRest_DataPrint.service;

import com.empresa.apiRest_DataPrint.model.Caracteristicas;
import com.empresa.apiRest_DataPrint.model.Carrito;
import com.empresa.apiRest_DataPrint.model.Usuarios;
import com.empresa.apiRest_DataPrint.repository.CaracteristicaRepository;
import com.empresa.apiRest_DataPrint.repository.CarritoRepository;
import com.empresa.apiRest_DataPrint.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoServiceImpl implements  CarritoService{
    @Autowired
    private CarritoRepository carritoRepository;
    @Autowired
    private CaracteristicaRepository caracteristicaRepository;
    @Autowired
    private UsuariosRepository usuariosRepository;
    @Override
    public Carrito agregarCarrito(Integer cantidad,Long caracteristica, Long usuario) {
        Caracteristicas caracteristicas = caracteristicaRepository.findById(caracteristica).get();
        Usuarios usuarios = usuariosRepository.findById(usuario).get();
        Carrito carrito = new Carrito();
        carrito.setCantidad(cantidad);
        carrito.setCaracateristica(caracteristicas);
        carrito.setUsuario(usuarios);
        carritoRepository.save(carrito);
        return carrito;
    }
}
