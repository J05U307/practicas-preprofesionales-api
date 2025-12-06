package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Proceso_Plan_Requisito;
import com.example.demo.repository.Proceso_Plan_RequisitoRepository;
import com.example.demo.service.Proceso_Plan_RequisitoService;

@Service

public class Proceso_Plan_RequisitoServiceImpl implements Proceso_Plan_RequisitoService{

	@Autowired
	private Proceso_Plan_RequisitoRepository repo; 
	
	@Override
	public Proceso_Plan_Requisito create(Proceso_Plan_Requisito c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public Proceso_Plan_Requisito update(Proceso_Plan_Requisito c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Optional<Proceso_Plan_Requisito> read(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Proceso_Plan_Requisito> readAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
