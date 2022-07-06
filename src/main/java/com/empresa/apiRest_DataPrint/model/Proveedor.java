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
@Table(name = "proveedores")
public class Proveedor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProveedor")
	private Long idProveedor;
	@Column(name = "nombreEmpresa", nullable = true, length = 45)
	private String nombreEmpresa;
	@Column(name = "correo", nullable = true, length = 45)
	private String correo;
	@Column(name = "telefono", nullable = true, length = 9)
	private String telefono;
	@Column(name = "direccion", nullable = true, length = 45)
	private String direccion;

}
