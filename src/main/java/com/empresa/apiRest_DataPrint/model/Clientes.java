package com.empresa.apiRest_DataPrint.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    @Column(name = "dni", nullable = true, length = 8)
    private String dni;
    @Column(name = "telefono", nullable = true, length = 45)
    private String telefono;
    
    
    @Column(name = "fecrea")
    @Temporal(TemporalType.TIMESTAMP)
    private Date  fecrea;
    
    @Column(name="direcc")
    private String direcc;
    
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

   

}
