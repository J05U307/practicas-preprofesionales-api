package com.example.demo.dto;

import lombok.Data;

@Data
public class Token {
	private String token; 
	private Long userId;
    private String role;
    private String nombre; 
    private String apellidos;
    private Long carrera_persona_id; 
}
