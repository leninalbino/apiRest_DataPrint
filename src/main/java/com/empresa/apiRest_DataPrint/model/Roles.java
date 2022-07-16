package com.empresa.apiRest_DataPrint.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString

@Entity
@Table(name = "roles")
public class Roles implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrol")
	private Long idrol;

	@Column(name = "rol", nullable = false)
	private String rol;

	public Roles(String rol) {
		this.rol = rol;
	}

	//@OneToMany(mappedBy = "roles",cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	//@JsonIgnoreProperties("roles")
	//private List<Usuarios> usuarios = new ArrayList<>();

	/* @ManyToMany(mappedBy = "roles",cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JsonIgnoreProperties("roles")
	private List<Usuarios> usuarios = new ArrayList<>();

	 */



}
