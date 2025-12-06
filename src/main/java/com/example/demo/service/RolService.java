package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Rol;

public interface RolService {
	
    Rol create(Rol c);
    Rol update(Rol c);
	void delete(Long id);
	Optional<Rol> read(Long id);
	List<Rol> readAll();

}
