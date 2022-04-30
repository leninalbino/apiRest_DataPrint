package com.empresa.apiRest_DataPrint.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Long idProducto;
    @Column(name = "imageProp")
    private String imageProp;
    @Column(name = "nombrePro")
    private String nombrePro;
    @Column(name = "cantidPro")
    private String cantidPro;
    @Column(name = "precio")
    private Double precio;

    public Producto(Long idProducto, String imageProp, String nombrePro, String cantidPro, Double precio) {
        this.idProducto = idProducto;
        this.imageProp = imageProp;
        this.nombrePro = nombrePro;
        this.cantidPro = cantidPro;
        this.precio = precio;
    }

    public Producto() {
        super();
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getImageProp() {
        return imageProp;
    }

    public void setImageProp(String imageProp) {
        this.imageProp = imageProp;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getCantidPro() {
        return cantidPro;
    }

    public void setCantidPro(String cantidPro) {
        this.cantidPro = cantidPro;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}
