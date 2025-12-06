package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Persona;

public interface PersonaService {
	
	Persona create(Persona c);
	Persona update(Persona c);
	void delete(Long id);
	Optional<Persona> read(Long id);
	List<Persona> readAll();

}
