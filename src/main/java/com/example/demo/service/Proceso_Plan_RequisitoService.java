package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Proceso_Plan_Requisito;

public interface Proceso_Plan_RequisitoService {
	
	Proceso_Plan_Requisito create(Proceso_Plan_Requisito c);
	Proceso_Plan_Requisito update(Proceso_Plan_Requisito c);
	void delete(Long id);
	Optional<Proceso_Plan_Requisito> read(Long id);
	List<Proceso_Plan_Requisito> readAll();

}
