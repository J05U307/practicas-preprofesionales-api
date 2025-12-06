package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Persona;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService{

	@Autowired
	private PersonaRepository repo; 
	
	@Override
	public Persona create(Persona c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public Persona update(Persona c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Optional<Persona> read(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Persona> readAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
