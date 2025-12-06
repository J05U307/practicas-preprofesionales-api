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
@Table(name = "requisitos")
public class Requisito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "requisito_seq_gen", sequenceName = "requisito_seq_gen", allocationSize = 1)
	@Column(name = "id_requisito")
	private Long id_requisito; 
	
	@Column(name = "nombre", length = 100)
	private String nombre;
	
	@Column(name = "descripcion", length = 300)
	private String descripcion;
	
	@Column(name = "estado", length = 1)
	private char estado;
	
	// Relacion de uno a muchos Requisito => Proceso_Plan_Requisito

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "requisito")
	@JsonIgnore
	private Set<Proceso_Plan_Requisito> proceso_plan_Requisitos;
	
	//Relacion de uno a muchos Requisito => Detalle ppp
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "requisito")
	@JsonIgnore
	private Set<Detalle_PPP> detalle_PPPs;
	


}
