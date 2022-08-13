package com.empresa.apiRest_DataPrint.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "detalleVentas")
public class DetalleVenta {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "caracteristica_id")
	private Caracteristicas caracteristica;
	private Integer cantida;
	private Double precio;
	private Float descuento;
	@ManyToOne
	@JoinColumn(name = "venta_id")
	private Ventas venta;
}
