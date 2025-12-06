package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "rol_seq_gen", sequenceName = "rol_seq_gen", allocationSize = 1)
	@Column(name = "id_rol")
	private Long id_rol;

	@Column(name = "rol", length = 100)
	private String rol;

	@Column(name = "estado", length = 1)
	private char estado;

	// Relacion de uno a muchos Rol => Acceso_Rol

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
	@JsonIgnore
	private Set<Acceso_Rol> acceso_Rols;

	// Relacion de uno a muchos Proceso => Proceso_Plan_Requisito

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
	@JsonIgnore
	private Set<Proceso_Plan_Requisito> proceso_plan_Requisitos;

	// Relacion de uno a muchos Rol => Detalle_ppp

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
	@JsonIgnore
	private Set<Detalle_PPP> detalle_PPPs;

	// Relacion de uno a muchos Rol => Rol_Persona

	// @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	// "rol")
	// @JsonIgnore
	// private Set<Rol_Persona> rol_Personas;

	
	// Relacion de muchos a muchos
	@ManyToMany(mappedBy = "roles")
	@JsonIgnore
	private Set<Persona> personas = new HashSet<>();
}
