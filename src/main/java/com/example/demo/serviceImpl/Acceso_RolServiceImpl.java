package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Acceso_Rol;
import com.example.demo.repository.Acceso_RolRepository;
import com.example.demo.service.Acceso_RolService;

@Service
public class Acceso_RolServiceImpl implements Acceso_RolService{

	@Autowired
	private Acceso_RolRepository repo;  
	
	@Override
	public Acceso_Rol create(Acceso_Rol c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public Acceso_Rol update(Acceso_Rol c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Optional<Acceso_Rol> read(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Acceso_Rol> readAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	

}
