package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RepresentanteLegal;
import com.example.demo.repository.RepresentanteLegalRepository;
import com.example.demo.service.RepresentanteLegalService;

@Service
public class RepresentanteLegalServiceImpl implements RepresentanteLegalService{
	
	@Autowired
	private RepresentanteLegalRepository repo;

	@Override
	public RepresentanteLegal create(RepresentanteLegal c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public RepresentanteLegal update(RepresentanteLegal c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Optional<RepresentanteLegal> read(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<RepresentanteLegal> readAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	} 
	
	
	

}
