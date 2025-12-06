package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Proceso;
import com.example.demo.repository.ProcesoRepository;
import com.example.demo.service.ProcesoService;

@Service
public class ProcesoServiceImpl implements ProcesoService {
	
	@Autowired
	private ProcesoRepository repo; 

	@Override
	public Proceso create(Proceso c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public Proceso update(Proceso c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Optional<Proceso> read(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Proceso> readAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
