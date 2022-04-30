package com.empresa.apiRest_DataPrint.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Clientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private Long idcliente;
    @Column(name = "nombre", nullable = true, length = 45)
    private String nombre;
    @Column(name = "apellido", nullable = true, length = 45)
    private String apellido;
    @Column(name = "telefono", nullable = true, length = 45)
    private String telefono;
    @Column(name = "usuario", nullable = true, length = 45)
    private String usuario;
    @Column(name = "clave", nullable = true, length = 45)
    private String clave;
    @Column(name = "fecrea")
    private LocalDate fecrea;
    @Column(name = "hocrea")
    private LocalTime hocre;

   

}
