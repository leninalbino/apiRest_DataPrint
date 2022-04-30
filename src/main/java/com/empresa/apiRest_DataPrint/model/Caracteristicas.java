package com.empresa.apiRest_DataPrint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="caracteristicas")
public class Caracteristicas {
 @Column(name = "id")  
 private int id; 
}
