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
@Table(name = "acceso_rol")
public class Acceso_Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "acceso_rol_seq_gen", sequenceName = "acceso_rol_seq_gen", allocationSize = 1)
	@Column(name = "id_acceso_rol")
	private Long id_acceso_rol; 
	
	// Relacion de muchos a uno Rol => Acceso_Rol
	
	@ManyToOne
	@JoinColumn(name = "id_rol", nullable = false)
	private Rol rol;
	
	// Relacion de muchos a uno Acceso => Acceso_Rol
	
	@ManyToOne
	@JoinColumn(name = "id_acceso", nullable = false)
	private Acceso acceso;
	
	

}
