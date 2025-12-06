package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Carrera_Persona;

public interface Carrera_PersonaService {
	
	Carrera_Persona create(Carrera_Persona c);
	Carrera_Persona update(Carrera_Persona c);
	void delete(Long id);
	Optional<Carrera_Persona> read(Long id);
	List<Carrera_Persona> readAll();

}
