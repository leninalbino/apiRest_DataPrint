package com.empresa.apiRest_DataPrint.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cupones")
public class Cupones implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcupones")
    private Long idcupones;
    @Column(name = "venciCupon")
    private LocalDate venciCupon;
    @Column(name = "descuCupon")
    private LocalDate descuCupon;
}
