package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Estado;

public interface EstadoService {
	
	Estado create(Estado c);
	Estado update(Estado c);
	void delete(Long id);
	Optional<Estado> read(Long id);
	List<Estado> readAll();

}
