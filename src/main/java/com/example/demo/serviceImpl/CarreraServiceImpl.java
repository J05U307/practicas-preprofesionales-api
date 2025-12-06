package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Carrera;
import com.example.demo.repository.CarreraRepository;
import com.example.demo.service.CarreraService;

@Service
public class CarreraServiceImpl implements CarreraService{

	@Autowired
	private CarreraRepository repo;
	@Override
	public Carrera create(Carrera c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public Carrera update(Carrera c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Optional<Carrera> read(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Carrera> readAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
