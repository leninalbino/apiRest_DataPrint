package com.empresa.apiRest_DataPrint.repository;

import com.empresa.apiRest_DataPrint.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarritoRepository extends JpaRepository <Carrito,Long> {

    @Query("select c from Carrito c where c.usuario.id=?1 and c.caracteristica.id=?2")
    public List<Carrito> listarCarrito( Long idUsuario, Long idCaracteristica);

    @Query(" select c from Carrito c where c.usuario.id=?1 and c.caracteristica.id=?2")
    public Carrito encontrarItem(Long idUsuario, Long idCaracteristica);

    @Query("update  Carrito set cantidad=?1 where idCarrito=?2")
    public Carrito actualizarItemCarrito(Long cantidad, Long id);

}
