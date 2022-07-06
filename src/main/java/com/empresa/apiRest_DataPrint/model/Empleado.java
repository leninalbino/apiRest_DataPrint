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
@Table(name = "empleados")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEmpleado")
	private Long idEmpleado;
	@Column(name = "nombresEml", nullable = true, length = 45)
	private String nombresEml;
	@Column(name = "apellidosEmpl", nullable = true, length = 45)
	private String apellidosEmpl;
	@Column(name = "dniEml", nullable = true, length = 8)
	private String dniEml;
	@Column(name = "correoEmpl", nullable = true, length = 45)
	private String correoEmpl;
	@Column(name = "passwordEmpl", nullable = true, length = 13)
	private String passwordEmpl;
	@Column(name = "rolEmpl", nullable = true, length = 45)
	private String rolEmpl;
	@Column(name = "estadoEmpl",nullable = true)
	private boolean estadoEmpl;
	

}
