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
@Table(name = "detalle_ppp")
public class Detalle_PPP {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "detalle_ppp_seq_gen", sequenceName = "detalle_ppp_seq_gen", allocationSize = 1)
	@Column(name = "id_detalle_ppp")
	private Long id_detalle_ppp;

	@Column(name = "orden_requisito", length = 100)
	private String orden_requisito;

	// Relacion de muchos a uno PPP=> Detalle ppp

	@ManyToOne
	@JoinColumn(name = "id_ppp", nullable = false)
	private PPP ppp;

	// Relacion de muchos a uno Rol=> Detalle ppp

	@ManyToOne
	@JoinColumn(name = "id_rol", nullable = false)
	private Rol rol;

	// Relacion de muchos a uno PPP=> Detalle ppp

	@ManyToOne
	@JoinColumn(name = "id_requisito", nullable = false)
	private Requisito requisito;
	
	//Relacion de uno a muchos Detalle ppp => Detalle Documento 
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "detalle_PPP")
	@JsonIgnore
	private Set<Detalle_Documento> detalle_Documentos;
}
