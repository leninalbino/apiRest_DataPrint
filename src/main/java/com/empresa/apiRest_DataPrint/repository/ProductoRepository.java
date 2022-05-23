package com.empresa.apiRest_DataPrint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.apiRest_DataPrint.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

	//Mostrar Producto
	@Query(value="select productos.idProductoPro,productos.estadoPro,productos.imageProp,productos.nombreProfrom productos inner join categorias on categorias.idcategorias = productos.categoria_id where categorias.nombreCate=?1",nativeQuery = true)
	public List<Producto> mostrarProductosXCategia(String nombreCategoria);
	
	@Query("select p from Producto p  where p.idProductoPro=?1")
	public Producto findByIdProductoPro(Long id);
	
	 @Query("select p.nombrePro from Producto p where p.nombrePro=?1")
	 public Producto findByNombre(String nombre);
	 
}
