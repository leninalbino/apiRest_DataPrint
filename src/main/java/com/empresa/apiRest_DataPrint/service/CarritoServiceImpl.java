package com.empresa.apiRest_DataPrint.service;

import com.empresa.apiRest_DataPrint.model.Caracteristicas;
import com.empresa.apiRest_DataPrint.model.Carrito;
import com.empresa.apiRest_DataPrint.model.Usuarios;
import com.empresa.apiRest_DataPrint.repository.CaracteristicaRepository;
import com.empresa.apiRest_DataPrint.repository.CarritoRepository;
import com.empresa.apiRest_DataPrint.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Usuarios usuarios = usuariosRepository.findById(usuario).orElse(null);
        Carrito carrito=carritoRepository.encontrarItem(usuario,caracteristica);
        if(carrito!= null){
            carrito.agregarCantidad(cantidad);
        }else{
            carrito = new Carrito();
            carrito.setCantidad(cantidad);
            carrito.setCaracteristica(caracteristicas);
            carrito.setUsuario(usuarios);
        }
        carritoRepository.save(carrito);
        return carrito;
    }

    @Override
    public List<Carrito> listarCarrito(Long idUsuario, Long idCaracteristica) {
        return carritoRepository.listarCarrito(idUsuario,idCaracteristica);
    }

    @Override
    public Optional eliminarItemCarrito(Long id) {
        List<Carrito> carrito = carritoRepository.findAll();
        if(id != null){
            carrito.stream().filter(item -> (item.getIdCarrito() == id)).findFirst();
            carritoRepository.deleteById(id);
        }
        return null;
    }

    @Override
    public Carrito actualizarItemCarrito(Long cantidad, Long id) {
        Carrito carrito = carritoRepository.findById(id).orElse(null);
        if(carrito.getIdCarrito() != null && carrito.getIdCarrito()==id && cantidad !=0){

            return carritoRepository.actualizarItemCarrito(cantidad,id);
        }else{
            return null;
        }

    }


}
