package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Evaluacion;
import com.example.demo.repository.EvaluacionRepository;
import com.example.demo.service.EvaluacionService;

@Service
public class EvaluacionServiceImpl implements EvaluacionService{

	@Autowired
	private EvaluacionRepository repo;
	@Override
	public Evaluacion create(Evaluacion c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public Evaluacion update(Evaluacion c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Optional<Evaluacion> read(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Evaluacion> readAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
