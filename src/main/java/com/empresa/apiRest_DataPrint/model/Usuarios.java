package com.empresa.apiRest_DataPrint.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "usuarios")
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuarios")
    private Long idusuarios;

    @Column(name = "usuario", nullable = true, length = 45)
    private String usuario;

    @Column(name = "clave", nullable = true, length = 45)
    private String clave;
    @Column(name = "fecrea")
    private LocalDate fecrea;

    @Column(name = "hocrea")
    private LocalTime hocrea;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "usuaRoles")
    private Roles usuaRoles;

    public Usuarios(Long idusuarios, String usuario, String clave, LocalDate fecrea, LocalTime hocrea,
            Roles usuaRoles) {
        this.idusuarios = idusuarios;
        this.usuario = usuario;
        this.clave = clave;
        this.fecrea = fecrea;
        this.hocrea = hocrea;
        this.usuaRoles = usuaRoles;
    }

    public Usuarios() {
        super();
    }

    public Long getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(Long idusuarios) {
        this.idusuarios = idusuarios;
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

    public Roles getUsuaRoles() {
        return usuaRoles;
    }

    public void setUsuaRoles(Roles usuaRoles) {
        this.usuaRoles = usuaRoles;
    }

}
