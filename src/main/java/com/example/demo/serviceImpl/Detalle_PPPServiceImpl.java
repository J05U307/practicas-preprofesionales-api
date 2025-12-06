package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Detalle_PPP;
import com.example.demo.repository.Detale_PPPRepository;
import com.example.demo.service.Detalle_PPPService;

@Service
public class Detalle_PPPServiceImpl implements Detalle_PPPService {

	@Autowired
	private Detale_PPPRepository repo;  
	
	
	@Override
	public Detalle_PPP create(Detalle_PPP c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public Detalle_PPP update(Detalle_PPP c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Optional<Detalle_PPP> read(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Detalle_PPP> readAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
