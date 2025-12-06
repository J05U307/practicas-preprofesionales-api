package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Requisito;
import com.example.demo.service.RequisitoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/requisito")
@CrossOrigin(origins = "http://localhost:4200")

public class RequisitoController {

	@Autowired
	private RequisitoService ser;

	@GetMapping
	public ResponseEntity<List<Requisito>> listar() {
		try {
			List<Requisito> alma = ser.readAll();
			if (alma.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(alma, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<Requisito> crear(@Valid @RequestBody Requisito c) {
		try {
			Requisito alms = ser.create(c);
			return new ResponseEntity<>(alms, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Requisito> buscar(@PathVariable("id") Long id){
		Optional<Requisito> alms= ser.read(id); 
		return alms.map(vale -> new ResponseEntity<>(vale, HttpStatus.OK) )
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Requisito> editar(@PathVariable("id") Long id, @Valid @RequestBody Requisito almas){
		 Optional<Requisito> existing = ser.read(id);
	        if (existing.isPresent()) {
	            almas.setId_requisito(id);
	            return new ResponseEntity<>(ser.update(almas), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable("id") Long id) {
        try {
            ser.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
}
