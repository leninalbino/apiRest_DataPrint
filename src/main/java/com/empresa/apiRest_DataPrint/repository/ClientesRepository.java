package com.empresa.apiRest_DataPrint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.empresa.apiRest_DataPrint.model.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {
	
	@Query("select c from Clientes c  where c.idcliente=?1")
	public Clientes findByIdCliente(Long id);
	
	@Query(" select c from Clientes c where c.usuario.id=?1")
    public Clientes encontrarItem(Long idUsuario);
	
	 @Query("select c from Clientes c where c.nombre like %?1")
	 public Clientes findByNombre(String nombre); 

}
