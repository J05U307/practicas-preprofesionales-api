package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Rol;
import com.example.demo.service.RolService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/rol")
@CrossOrigin(origins = "http://localhost:4200")

public class RolController {
	@Autowired
	private RolService ser;
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping
	public ResponseEntity<List<Rol>> listar(){
		try {
			List<Rol> alma= ser.readAll(); 
			if (alma.isEmpty()) {
				return new  ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			return new ResponseEntity<>(alma, HttpStatus.OK); 
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@PostMapping
	public ResponseEntity<Rol> crear(@Valid @RequestBody Rol c){
		try {
			Rol  alms= ser.create(c); 
			return new ResponseEntity<>(alms, HttpStatus.CREATED);  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("/{id}")
	public ResponseEntity<Rol> buscar(@PathVariable("id") Long id){
		Optional<Rol> alms= ser.read(id); 
		return alms.map(vale -> new ResponseEntity<>(vale, HttpStatus.OK) )
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@PutMapping("/{id}")
	public ResponseEntity<Rol> editar(@PathVariable("id") Long id, @Valid @RequestBody Rol almas){
		 Optional<Rol> existing = ser.read(id);
	        if (existing.isPresent()) {
	            almas.setId_rol(id);
	            return new ResponseEntity<>(ser.update(almas), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
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
