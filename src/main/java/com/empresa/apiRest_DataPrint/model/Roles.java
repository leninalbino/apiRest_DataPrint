package com.empresa.apiRest_DataPrint.model;

import java.io.Serializable;
<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> main
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
<<<<<<< HEAD

import lombok.AllArgsConstructor;
=======
>>>>>>> main
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "roles")
public class Roles implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrol")
	private Long idrol;

<<<<<<< HEAD
	@Column(name = "tipuser", nullable = false)
	private String tipuser;

	/*
	 * @OneToMany(mappedBy = "usuario")
	 * 
	 * @JsonIgnoreProperties("usuario") private List<Usuarios> usuarios;
	 */

	public Roles(Long idrol, String tipuser) {
		super();
		this.idrol = idrol;
		this.tipuser = tipuser;
	}

	public Roles() {
		super();
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

=======
    @OneToMany(mappedBy = "usuaRoles",cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JsonIgnoreProperties("usuaRoles")
    private List<Usuarios> usuarios = new ArrayList<>();

    
    
>>>>>>> main
}
