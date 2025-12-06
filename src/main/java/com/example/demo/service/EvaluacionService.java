package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Evaluacion;

public interface EvaluacionService {

	Evaluacion create(Evaluacion c);
	Evaluacion update(Evaluacion c);
	void delete(Long id);
	Optional<Evaluacion> read(Long id);
	List<Evaluacion> readAll();
}
