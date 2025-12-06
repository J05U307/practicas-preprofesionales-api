package com.example.demo.entity;


import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
@Table(name = "personas")
public class Persona {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "persona_seq_gen", sequenceName = "persona_seq_gen", allocationSize = 1)
	@Column(name = "id_persona")
	private Long id_persona; 
	
	@Column(name = "nombre", length = 100)
	private String nombre;
	
	@Column(name = "apellidos", length = 100)
	private String apellidos;
	
	@Column(name = "codigo", length = 9)
	private String codigo;
	
	@Column(name = "dni", length = 8)
	private String dni;
	
	@Column(name = "usuario", length = 100)
	private String usuario;
	
	@Column(name = "clave", length = 100)
	private String clave;
	
	@Column(name = "correro_institucional", length = 100)
	private String correro_institucional;
	
	@Column(name = "telefono", length = 100)
	private String telefono;
	
	@Column(name = "estado", length = 1)
	private char estado; 
	
	// Relacion de uno a muchos  Persona => RepresentanteLegal
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "persona")
	@JsonIgnore
	private Set<RepresentanteLegal> representanteLegals;
	
	
	// Relacion de uno a muchos Persona => Carrera_Persona
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "persona")
	@JsonIgnore
	private Set<Carrera_Persona> carrera_Personas;
	
	
	
	// Relacion de uno a muchos Persona  => Rol_Persona
	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "persona")
	//@JsonIgnore
    //	private Set<Rol_Persona> rol_Personas;
	
	
	// Relacion de muchos a muchos rol_persona
	@ManyToMany(fetch = FetchType.EAGER)
	
	@JoinTable(
			name="Rol_Persona",
			joinColumns = @JoinColumn(name="id_persona", referencedColumnName = "id_persona"),
			inverseJoinColumns = @JoinColumn(name="id_rol", referencedColumnName = "id_rol")
			)
	private Set<Rol> roles;
	
	
}
