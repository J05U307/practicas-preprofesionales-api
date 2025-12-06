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
@Table(name = "proceso_plan_requisito")
public class Proceso_Plan_Requisito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "proceso_plan_requisito_seq_gen", sequenceName = "proceso_plan_requisito_seq_gen", allocationSize = 1)
	@Column(name = "id_proceso_plan_requisito")
	private Long id_proceso_plan_requisito; 
	
	@Column(name = "requisito_orden")
	private Long requisito_orden;
	
	
	// 1 
	// Relacion de muchos a uno Proceso => Proceso_Plan_Requisito
	
	@ManyToOne
	@JoinColumn(name = "id_proceso", nullable = false)
	private Proceso proceso;
	
	//2
	// Relacion de muchos a uno Rol => Proceso_Plan_Requisito
	
	@ManyToOne
	@JoinColumn(name = "id_rol", nullable = false)
	private Rol rol;
	
	//3
	// Relacion de muchos a uno Requisito => Proceso_Plan_Requisito
	
	@ManyToOne
	@JoinColumn(name = "id_requisito", nullable = false)
	private Requisito requisito;
	

}
