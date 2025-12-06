package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.RepresentanteLegal;

public interface RepresentanteLegalService {
	
	RepresentanteLegal create(RepresentanteLegal c);
	RepresentanteLegal update(RepresentanteLegal c);
	void delete(Long id);
	Optional<RepresentanteLegal> read(Long id);
	List<RepresentanteLegal> readAll();

}
