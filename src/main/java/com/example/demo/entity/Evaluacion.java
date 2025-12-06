package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "evaluaciones")

public class Evaluacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "evaluacion_seq_gen", sequenceName = "evaluacion_seq_gen", allocationSize = 1)
	@Column(name = "id_evaluacion")
	private Long id_evaluacion; 
	
	@Column(name = "nota")
	private Long nota;
	
	// Relacion de muchos a uno PPP=> Evaluacion 
	
	
	@ManyToOne
	@JoinColumn(name = "id_ppp", nullable = false)
	private PPP ppp;
	
}
