package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Proceso;

public interface ProcesoService {
	
	Proceso create(Proceso c);
	Proceso update(Proceso c);
	void delete(Long id);
	Optional<Proceso> read(Long id);
	List<Proceso> readAll();

}
