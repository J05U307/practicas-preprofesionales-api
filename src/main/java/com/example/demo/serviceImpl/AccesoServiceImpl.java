package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Acceso;
import com.example.demo.repository.AccesoRepository;
import com.example.demo.service.AccesoService;

@Service
public class AccesoServiceImpl implements AccesoService {
	@Autowired
	private AccesoRepository repo;

	@Override
	public Acceso create(Acceso c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public Acceso update(Acceso c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Optional<Acceso> read(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Acceso> readAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	} 

}
