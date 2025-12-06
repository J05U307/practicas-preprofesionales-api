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
@Table(name = "detalle_documento")
public class Detalle_Documento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "detalle_documento_seq_gen", sequenceName = "detalle_documento_seq_gen", allocationSize = 1)
	@Column(name = "id_detalle_documento")
	private Long id_detalle_documento; 
	
	@Column(name = "archivo", length = 100)
	private String archivo;
	
	@Column(name = "direccion_archivo", length = 100)
	private String direccion_archivo;
	
	// Relacion de muchos a uno Detalle_pp => Detalle Documento
	
	@ManyToOne
	@JoinColumn(name = "id_detalle_ppp", nullable = false)
	private Detalle_PPP detalle_PPP;

}
