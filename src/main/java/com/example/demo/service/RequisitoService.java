package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Requisito;

public interface RequisitoService {
	
	Requisito create(Requisito c);
	Requisito update(Requisito c);
	void delete(Long id);
	Optional<Requisito> read(Long id);
	List<Requisito> readAll();

}