package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Acceso_Rol;


public interface Acceso_RolService {
	
	Acceso_Rol create(Acceso_Rol c);
	Acceso_Rol update(Acceso_Rol c);
	void delete(Long id);
	Optional<Acceso_Rol> read(Long id);
	List<Acceso_Rol> readAll();

}
