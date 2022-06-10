package com.empresa.apiRest_DataPrint.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "usuarios")
public class UsuariosDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuarios")
    private Long idusuarios;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "clave", nullable = false)
    private String clave;

    @Column(name = "fecrea")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecrea;

    @ManyToOne
    @JoinColumn(name = "idrol")
    @JsonIgnoreProperties
    private Roles roles;

    public Usuarios getUsuariosFromDto(){
        Usuarios usuarios = new Usuarios();
        usuarios.setCorreo(correo);
        usuarios.setClave(clave);
        usuarios.setFecrea(fecrea);

        return usuarios;
    }
}
