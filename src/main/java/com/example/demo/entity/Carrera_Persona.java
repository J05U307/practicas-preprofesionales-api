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
import jakarta.persistence.ManyToOne;
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
@Table(name = "carrera_pesona")
public class Carrera_Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "carrera_persona_seq_gen", sequenceName = "persona_seq_gen", allocationSize = 1)
	@Column(name = "id_carrera_persona")
	private Long id_carrera_persona; 
	
	
	// Relacion de muchos a uno Persona => Carrera Persona
	
	@ManyToOne
	@JoinColumn(name = "id_persona", nullable = false)
	private Persona persona;
	
	// Relacion de muchos a uno Carrera => Carrera Persona
	
	@ManyToOne
	@JoinColumn(name = "id_carrera", nullable =  false)
	private Carrera carrera;
	
	//Relacion de uno a muchos Carrera_Persona => PPP
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "carrera_persona")
	@JsonIgnore
	private Set<PPP> ppps;
	
	
	
}
