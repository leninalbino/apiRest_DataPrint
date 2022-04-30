package com.empresa.apiRest_DataPrint.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Roles  implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private Long idrol;

    @Column(name = "tipuser")
    private String tipuser; 

    @OneToMany(mappedBy = "usuaRoles",cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    private Set<Usuarios> usuarios= new HashSet<>();

    public Roles(Long idrol, String tipuser, Set<Usuarios> usuarios) {
        this.idrol = idrol;
        this.tipuser = tipuser;
        this.usuarios = usuarios;
    }

    public Long getIdrol() {
        return idrol;
    }

    public void setIdrol(Long idrol) {
        this.idrol = idrol;
    }

    public String getTipuser() {
        return tipuser;
    }

    public void setTipuser(String tipuser) {
        this.tipuser = tipuser;
    }

    public Set<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }

    
}
