package com.empresa.apiRest_DataPrint.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@Entity
@Table(name = "caracteristicas")
public class Caracteristicas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCaracteristica;

    @Column(name = "descriCaract")
    private String descriCaract;
    
    @Column(name = "cantidCaract")
    private String cantidCaract;
    @Column(name = "precioCaract")
    private Double precioCaract;
    
    @ManyToOne(fetch = FetchType.LAZY)// carga peresosa
    @JoinColumn(name="producto_id")
    private Producto producto;
}
