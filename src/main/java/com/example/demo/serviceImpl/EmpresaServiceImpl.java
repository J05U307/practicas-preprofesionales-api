package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Empresa;
import com.example.demo.repository.EmpresaRepository;
import com.example.demo.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository repo; 
	@Override
	public Empresa create(Empresa c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public Empresa update(Empresa c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Optional<Empresa> read(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Empresa> readAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
