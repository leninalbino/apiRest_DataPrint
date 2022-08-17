package com.empresa.apiRest_DataPrint.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.apiRest_DataPrint.model.Categorias;
import com.empresa.apiRest_DataPrint.model.Proveedor;
import com.empresa.apiRest_DataPrint.repository.CategoriasRepository;

@Service
public class CategoriasServiceImpl implements CategoriasService {
	
	@Autowired
	public CategoriasRepository categoriasRespository;

	@Override
	public Categorias agregarCategorias(Categorias categoria) {
			//Categorias c = new Categorias();
			//c.setNombreCate(categoria.getNombreCate());
			return categoriasRespository.save(categoria);
		
	}

	@Override
	public Categorias editarCategorias(Categorias categoria) {
		return categoriasRespository.saveAndFlush(categoria);
		
	}

	
	@Override
	public List<Categorias> listarCategorias() {
		List<Categorias> lista= new ArrayList<Categorias>();
		Categorias c = null;
		for(Categorias categoria : categoriasRespository.findAll()) {
			c= new Categorias();
			c.setIdcategorias(categoria.getIdcategorias());
			c.setNombreCate(categoria.getNombreCate());
			lista.add(c);
		}
		return lista;
	}

	@Override
	public Categorias buscarCategoriasId(Long id) {
		return categoriasRespository.findByIdcategorias(id);
	}

	//@Override
	//public Optional eliminarCategorias(Long id) {
	//	List<Categorias> categorias = categoriasRespository.findAll();
	//	if(id != null) {
	//		categorias.stream().filter(item -> (item.getIdcategorias() == id)).findFirst();
    //       categoriasRespository.deleteById(id);
	//	}
	//	return null;
	//}

	@Override
	public Categorias  buscarByNombre(String nombre) {

			return categoriasRespository.findByNombre(nombre);


	}

	@Override
	public boolean eliminarCategorias(Long id) {
		Optional<Categorias> _c=categoriasRespository.findById(id);
		if(_c!=null) {
			categoriasRespository.delete(_c.get());
			return true;
		}
		return false;
	}

	@Override
	public Categorias obtenerCategoriaId(Long id) {
		return categoriasRespository.findByIdcategorias(id);
	}

	

}
