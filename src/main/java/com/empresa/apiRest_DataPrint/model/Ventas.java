package com.empresa.apiRest_DataPrint.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

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
@Table(name = "ventas")
public class Ventas implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idventas")
    private Long idventas;

    @Column(name = "precioTotal")
    private float precioTotal;

    @Column(name = "fecvent")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecvent;
    
    @ManyToOne
    @JoinColumn(name="pago_id")
    private Pagos pago;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;
}
