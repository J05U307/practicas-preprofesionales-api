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
@Table(name = "empresas")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "empresa_seq_gen", sequenceName = "empresa_seq_gen", allocationSize = 1)
	@Column(name = "id_empresa")
	private Long id_empresa;

	@Column(name = "razon_social", length = 100)
	private String razon_social;

	@Column(name = "direccion", length = 100)
	private String direccion;

	@Column(name = "ruc", length = 100)
	private String ruc;

	@Column(name = "telefono", length = 9)
	private String telefono;

	@Column(name = "sector", length = 100)
	private String sector;

	@Column(name = "pagina_web", length = 200)
	private String pagina_web;
	
	@Column(name = "codigo_postal", length = 100)
	private String codigo_postal;

	// Relacion de uno a muchos Empresa => RepresentanteLegal

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "empresa")
	@JsonIgnore
	private Set<RepresentanteLegal> representanteLegals;

	// Relacion de uno a muchos Empresa => ppp

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "empresa")
	@JsonIgnore
	private Set<PPP> ppps;

}
