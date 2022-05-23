package com.empresa.apiRest_DataPrint.controller;

import com.empresa.apiRest_DataPrint.model.Caracteristicas;
import com.empresa.apiRest_DataPrint.model.Carrito;
import com.empresa.apiRest_DataPrint.repository.CaracteristicaRepository;
import com.empresa.apiRest_DataPrint.repository.UsuariosRepository;
import com.empresa.apiRest_DataPrint.service.CaracteristicaService;
import com.empresa.apiRest_DataPrint.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/v1/carrito")
public class CarritoController {
    @Autowired
    private CarritoService carritoService;
    @Autowired
    private CaracteristicaService caracteristicaService;
    @Autowired
    private UsuariosRepository usuariosRepository;

    @PostMapping("/agregarCarrito")
    public ResponseEntity<?> agregarCarrito(@RequestParam ("caracteristica_id") Long caracteristica_id,
                                            @RequestParam("usuario_id") Long usuario_id,
                                            @RequestParam ("cantidad") Integer cantidad){
            Integer totalCantidad=0;
           Caracteristicas caracteristicas =caracteristicaService.buscarCaracteristicaId(caracteristica_id);
            List<Carrito> items= carritoService.listarCarrito(usuario_id, caracteristica_id);
           for(Carrito item: items){
                totalCantidad += (item.getCantidad()+cantidad);
           }
           if(totalCantidad > caracteristicas.getCantidCaract()){
                return null;
           }else{
               Carrito carrito =carritoService.agregarCarrito(cantidad,caracteristica_id,usuario_id);
               return ResponseEntity.status(HttpStatus.CREATED).body(carrito);
           }

    }
    @DeleteMapping("/eliminarItemCarrito/{id}")
    public ResponseEntity<?> eliminarItemCarrito(@PathVariable("id") long id){
        Map <String,Object> response = new HashMap<>();
        carritoService.eliminarItemCarrito(id);
        response.put("mensaje", "Eliminado Correctamente");
        return ResponseEntity.ok(response);
    }
    @PutMapping("actualizarItemCarrito/{cantidad}/{idCarrito}")
    public ResponseEntity<?>actualizarItemCarrito(@PathVariable("cantidad") long cantidad,
                                                  @PathVariable("idCarrito") long idCarrito){
        Map <String,Object> response = new HashMap<>();
        carritoService.actualizarItemCarrito(cantidad,idCarrito);
        response.put("mensaje", "Actualizado Correctamente");
        return ResponseEntity.ok(response);
    }

}
