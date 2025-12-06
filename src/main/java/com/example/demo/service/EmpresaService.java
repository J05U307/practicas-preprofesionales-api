package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Empresa;

public interface EmpresaService {
	
	Empresa create(Empresa c);
	Empresa update(Empresa c);
	void delete(Long id);
	Optional<Empresa> read(Long id);
	List<Empresa> readAll();

}
