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
@Table(name = "procesos")
public class Proceso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "proceso_seq_gen", sequenceName = "proceso_seq_gen", allocationSize = 1)
	@Column(name = "id_proceso")
	private Long id_proceso; 
	
	@Column(name = "nombre", length = 100)
	private String nombre;
	
	@Column(name = "descripcion", length = 100)
	private String descripcion;
	
	@Column(name = "estado", length = 1)
	private char estado; 
	
	// Relacion de uno a muchos Proceso => Proceso_Plan_Requisito
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "proceso")
	@JsonIgnore
	private Set<Proceso_Plan_Requisito> proceso_plan_Requisitos;
	
	
}
