package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PPP;
import com.example.demo.repository.PPPRepository;
import com.example.demo.service.PPPService;

@Service
public class PPPServiceImpl implements PPPService{

	@Autowired
	private PPPRepository repo;

	@Override
	public PPP create(PPP c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public PPP update(PPP c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Optional<PPP> read(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<PPP> readAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}


	
}
