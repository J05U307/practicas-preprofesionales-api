package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Detalle_PPP;

public interface Detalle_PPPService {
	Detalle_PPP create(Detalle_PPP c);
	Detalle_PPP update(Detalle_PPP c);
	void delete(Long id);
	Optional<Detalle_PPP> read(Long id);
	List<Detalle_PPP> readAll();

}
