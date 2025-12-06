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
@Table(name = "carreras")
public class Carrera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "carrera_seq_gen", sequenceName = "carrera_seq_gen", allocationSize = 1)
	@Column(name = "id_carr")
	private Long id_carr; 
	
	@Column(name = "nombre", length = 100)
	private String nombre;
	
	@Column(name = "estado", length = 1)
	private char estado; 
	
	// Relacion de  uno a muchos Carrera => Carrera_Persona
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "carrera")
	@JsonIgnore
	private Set<Carrera_Persona> carrera_Personas;
	
	
	
	
	
}
