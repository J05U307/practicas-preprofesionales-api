package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Estado;
import com.example.demo.repository.EstadoRepository;
import com.example.demo.service.EstadoService;

@Service

public class EstadoServiceImpl implements EstadoService{

	@Autowired
	private EstadoRepository repo;
	@Override
	public Estado create(Estado c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public Estado update(Estado c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Optional<Estado> read(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Estado> readAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	

}
