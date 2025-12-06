package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Detalle_Documento;
import com.example.demo.repository.Detalla_DocumentoRepository;
import com.example.demo.service.Detalle_DocumentoService;

@Service
public class Detalle_DocumentoServiceImpl implements Detalle_DocumentoService{

	@Autowired
	private Detalla_DocumentoRepository repo; 
	@Override
	public Detalle_Documento create(Detalle_Documento c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public Detalle_Documento update(Detalle_Documento c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Optional<Detalle_Documento> read(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Detalle_Documento> readAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
