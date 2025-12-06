package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Requisito;
import com.example.demo.repository.RequisitoRepository;
import com.example.demo.service.RequisitoService;

@Service
public class RequisitoServiceImpl implements RequisitoService {

	@Autowired
	private RequisitoRepository repo; 
	@Override
	public Requisito create(Requisito c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public Requisito update(Requisito c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Optional<Requisito> read(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Requisito> readAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
