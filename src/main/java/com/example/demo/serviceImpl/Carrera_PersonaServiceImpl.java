package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Carrera_Persona;
import com.example.demo.repository.Carrera_PesonaRepository;
import com.example.demo.service.Carrera_PersonaService;

@Service
public class Carrera_PersonaServiceImpl implements Carrera_PersonaService{
	
	@Autowired
	private Carrera_PesonaRepository repo; 

	@Override
	public Carrera_Persona create(Carrera_Persona c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public Carrera_Persona update(Carrera_Persona c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Optional<Carrera_Persona> read(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Carrera_Persona> readAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
