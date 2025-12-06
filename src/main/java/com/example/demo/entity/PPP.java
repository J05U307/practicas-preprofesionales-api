package com.example.demo.entity;

import java.sql.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PPP")
public class PPP {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "ppp_seq_gen", sequenceName = "ppp_seq_gen", allocationSize = 1)
	@Column(name = "id_ppp")
	private Long id_ppp;

	@Column(name = "Fecha_inicio")
	@Temporal(TemporalType.DATE)
	private Date Fecha_inicio;

	@Column(name = "Fecha_final")
	@Temporal(TemporalType.DATE)
	private Date Fecha_final;

	@Column(name = "horas_trabajadas")
	private Double horas_trabajadas;

	@Column(name = "promedio")
	private Double promedio;

	// Relacion de muchos a uno Estado => PPP

	@ManyToOne
	@JoinColumn(name = "id_estado", nullable = false)
	private Estado estado;

	// Relacion de muchos a uno Empresa => ppp

	@ManyToOne
	@JoinColumn(name = "id_empresa", nullable = false)
	private Empresa empresa;

	// Relacion de muchos a uno Empresa => ppp

	@ManyToOne
	@JoinColumn(name = "id_carrera_persona", nullable = false)
	private Carrera_Persona carrera_persona;
	
	//Relacion de uno a muchos PPP => Detalle_ppp
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ppp")
	@JsonIgnore
	private Set<Detalle_PPP> detalle_PPPs;
	
	//Relaciones de uno a muchos PPP =>  Evaluacion 
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ppp")
	@JsonIgnore
	private Set<Evaluacion> evaluacions;
	
	

}
