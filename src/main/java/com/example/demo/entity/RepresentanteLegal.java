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
@Table(name = "representantes_legales")
public class RepresentanteLegal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "representantelegal_seq_gen", sequenceName = "representantelegal_seq_gen", allocationSize = 1)
	@Column(name = "id_representante_legal")
	private Long id_representante_legal; 
	
	@Column(name = "cargo", length = 100)
	private String cargo;
	
	// Relacion de muchos a uno persona => Representantelegal 
	
	@ManyToOne
	@JoinColumn(name = "id_persona", nullable = false)
	private Persona persona;

	// Relacion de muchos a uino Empresa => Representantelegal
	@ManyToOne
	@JoinColumn(name = "id_empresa", nullable = false)
	private Empresa empresa;
	
}
