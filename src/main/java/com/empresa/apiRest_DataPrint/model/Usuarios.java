package com.empresa.apiRest_DataPrint.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuarios")
    private Long idusuarios;

    @Column(name = "correo", nullable = false, length = 45)
    private String correo;

    @Column(name = "clave", nullable = false, length = 45)
    private String clave;
    
    @Column(name = "fecrea")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecrea;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "usuaRoles")
    private Roles usuaRoles;
    
    
    
    
    
    

   

}
