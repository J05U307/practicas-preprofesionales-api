package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.PPP;

public interface PPPService {

	PPP create(PPP c);
	PPP update(PPP c);
	void delete(Long id);
	Optional<PPP> read(Long id);
	List<PPP> readAll();
	
	
	
}
