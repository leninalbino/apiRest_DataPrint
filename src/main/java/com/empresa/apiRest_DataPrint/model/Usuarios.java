package com.empresa.apiRest_DataPrint.model;

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
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "usuario", nullable = true, length = 45)
    private String usuario;

    @Column(name = "clave", nullable = true, length = 45)
    private String clave;

    @Column(name = "tipuser")
    private String tipuser;

    @Column(name = "fecrea")
    private LocalDate fecrea;

    @Column(name = "hocrea")
    private LocalTime hocrea;

    public Usuarios(int id, String usuario, String clave, String tipuser, LocalDate fecrea, LocalTime hocrea) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
        this.tipuser = tipuser;
        this.fecrea = fecrea;
        this.hocrea = hocrea;
    }

    public Usuarios() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipuser() {
        return tipuser;
    }

    public void setTipuser(String tipuser) {
        this.tipuser = tipuser;
    }

    public LocalDate getFecrea() {
        return fecrea;
    }

    public void setFecrea(LocalDate fecrea) {
        this.fecrea = fecrea;
    }

    public LocalTime getHocrea() {
        return hocrea;
    }

    public void setHocrea(LocalTime hocrea) {
        this.hocrea = hocrea;
    }
    
}
