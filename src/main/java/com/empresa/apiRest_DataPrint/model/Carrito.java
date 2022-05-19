package com.empresa.apiRest_DataPrint.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@Entity
@Table(name = "carrito")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Carrito implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrito;
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name="caracteristica_id")
    private Caracteristicas caracateristica;
    
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuarios usuario;

}
