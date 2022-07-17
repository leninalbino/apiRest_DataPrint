package com.empresa.apiRest_DataPrint.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString

@Entity
@Table(name = "usuarios")
public class Usuarios  {
	private static final long serialVersionUID = 1L;

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

	private Boolean enable;
	// en la relacion de many to one va el @JoinColumn y colocamos
	// un nombre como referencia
	//@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	//@JoinColumn(name = "idrol")
	//private Roles roles;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuarios_roles", joinColumns =
	@JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "role_id"),
			uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "role_id"})})
	private List<Roles> roles;

	@OneToOne(mappedBy = "usuario")
	@JsonIgnoreProperties("usuario")
	private Clientes clientes;


}
