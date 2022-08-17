package com.empresa.apiRest_DataPrint.controller;

import com.empresa.apiRest_DataPrint.model.Caracteristicas;
import com.empresa.apiRest_DataPrint.model.Carrito;
import com.empresa.apiRest_DataPrint.model.Usuarios;
import com.empresa.apiRest_DataPrint.repository.CaracteristicaRepository;
import com.empresa.apiRest_DataPrint.repository.UsuariosRepository;
import com.empresa.apiRest_DataPrint.service.CaracteristicaService;
import com.empresa.apiRest_DataPrint.service.CarritoService;
import com.empresa.apiRest_DataPrint.service.UsuariosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    @Autowired
    private UsuariosService usuariosService;
    Logger  logger= LoggerFactory.getLogger(CarritoController.class);
    @GetMapping("/")
    public ResponseEntity <List<?>>listarItemsCarrito(Principal principal){
        Usuarios usuarios = usuariosService.encontrarCorrero(principal.getName());
        List<Carrito> carritos = carritoService.encontrarItemUsuario(usuarios.getIdusuarios());
        return ResponseEntity.ok(carritos);
    }
    @PostMapping("/agregarCarrito")
    public ResponseEntity<?> agregarCarrito(@RequestParam ("caracteristica_id") Long caracteristica_id,
                                            @RequestParam ("cantidad") Integer cantidad,
                                            Principal principal ){
        Map <String,Object> response = new HashMap<>();
            Integer totalCantidad=0;
            Caracteristicas caracteristicas =caracteristicaService.buscarCaracteristicaId(caracteristica_id);
            Usuarios usuarios = usuariosRepository.findByCorreo(principal.getName());
            List<Carrito> items= carritoService.listarCarrito(usuarios.getIdusuarios(), caracteristica_id);
           for(Carrito item: items){
                totalCantidad += (item.getCantidad()+cantidad);
           }
           if(totalCantidad > caracteristicas.getCantidCaract()){
               response.put("mensaje","La cantidad agregada "+ totalCantidad + " es superior a la cantidad del producto "+ caracteristicas.getCantidCaract());
                return ResponseEntity.status(HttpStatus.OK).body(response);
           }
           carritoService.agregarCarrito(cantidad,caracteristica_id,usuarios.getIdusuarios());
            response.put("mensaje", "item agregado correctamente");
           return ResponseEntity.status(HttpStatus.CREATED).body(response);


    }
    @DeleteMapping("/eliminarItemCarrito/{id}")
    public ResponseEntity<?> eliminarItemCarrito(@PathVariable("id") long id){
        Map <String,Object> response = new HashMap<>();
        carritoService.eliminarItemCarrito(id);
        response.put("mensaje", "Eliminado Correctamente");
        return ResponseEntity.ok(response);
    }
    @PutMapping("/actualizarItemCarrito/{cantidad}/{idCarrito}")
    public ResponseEntity<?>actualizarItemCarrito(@PathVariable("cantidad") Integer cantidad,
                                                  @PathVariable("idCarrito") long idCarrito){
        Map <String,Object> response = new HashMap<>();
        var carrito=carritoService.actualizarItemCarrito(cantidad,idCarrito);
        if (carrito != null){
            response.put("mensaje", "Actualizado Correctamente");
            return ResponseEntity.ok(response);
        }
        response.put("mensaje", "No se puede actualizar");
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
    }
    public Map<String,Object> message(String message){
        Map <String,Object> response = new HashMap<>();
        response.put("message", message);
        return response;
    }

}
