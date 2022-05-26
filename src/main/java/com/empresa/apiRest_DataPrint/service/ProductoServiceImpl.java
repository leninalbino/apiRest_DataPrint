package com.empresa.apiRest_DataPrint.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.empresa.apiRest_DataPrint.model.Caracteristicas;
import com.empresa.apiRest_DataPrint.model.Categorias;
import com.empresa.apiRest_DataPrint.model.Producto;
import com.empresa.apiRest_DataPrint.repository.CaracteristicaRepository;
import com.empresa.apiRest_DataPrint.repository.CategoriasRepository;
import com.empresa.apiRest_DataPrint.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	@Autowired
	private ProductoRepository productoRepo;
	
	@Autowired
    private CategoriasRepository categoriaRepository;
    @Autowired
    private CaracteristicaRepository caracteristicaRepository;
 
	
	
	@Override
	public List<Producto> ListarProductos() {
		// TODO Auto-generated method stub
		return productoRepo.findAll();
	}

	@Override
	public Producto ActualizarProducto(Producto producto) {
		 Categorias categorias = categoriaRepository.findById(producto.getCategoria().getIdcategorias()).orElse(null);
		 return productoRepo.saveAndFlush(producto);
	}

	@Override
	public Producto buscarProductoId(Long id) {
		
		return productoRepo.findByIdProductoPro(id);
	}

	@Override
	public Producto agregarProducto(Producto producto) {
		
        Categorias categorias = categoriaRepository.findById(producto.getCategoria().getIdcategorias()).orElse(null);
        //Producto product = new Producto();
        
        //List<Producto> p= new ArrayList<Producto>();
        //Producto p= productoRepo.findByNombre(nombrePro);
		
			// if( p!=null) {
				 //Producto pro=(p == null) ? p.getNombrePro() :p;
				// return null;
			 //}else {
				 	//producto.setImageProp(imageProp);
			        //producto.setNombrePro(nombrePro);
			        //producto.setEstadoPro(estadoPro);
			        //producto.setCategoria(categorias);
			        
			 //}
		 
			return productoRepo.save(producto);
   //     return producto;
	}

	@Override
	public Optional eliminarProducto(Long id) {
		List<Producto> productos = productoRepo.findAll();
		if(id != null) {
			productos.stream().filter(item -> (item.getIdProductoPro() == id)).findFirst();
            productoRepo.deleteById(id);
		}
		return null;
	}

	@Override
	public Producto buscarByNombre(String nombre) {
		// TODO Auto-generated method stub
		return productoRepo.findByNombre(nombre);
	}
}
