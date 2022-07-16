package com.empresa.apiRest_DataPrint.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProductoPro")
    private Long idProductoPro;
    @Column(name = "imageProp")
    private String imageProp;
    @Column(name = "nombrePro")
    private String nombrePro;

    private boolean estadoPro;

	//@JsonIgnore
    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categorias categoria;

   	//@JsonIgnore
    @OneToMany(mappedBy = "producto")
	@JsonIgnoreProperties("producto")
    private List<Caracteristicas> caracteristicas;


	//public static long getSerialversionuid() {
		//return serialVersionUID;
	//}
    
    
}
