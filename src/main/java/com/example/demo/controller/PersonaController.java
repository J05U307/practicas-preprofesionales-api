package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Persona;
import com.example.demo.service.PersonaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/persona")
@CrossOrigin(origins = "http://localhost:4200")

public class PersonaController {
	
	@Autowired
	private PersonaService ser;
	
	// Para encriptar la contraseña 
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping
	public ResponseEntity<List<Persona>> listar(){
		try {
			List<Persona> alma= ser.readAll(); 
			if (alma.isEmpty()) {
				return new  ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			return new ResponseEntity<>(alma, HttpStatus.OK); 
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	
	@PreAuthorize("hasRole('ADMIN') ")
	@PostMapping
	public ResponseEntity<Persona> crear(@Valid @RequestBody Persona c){
		try {
			c.setClave(passwordEncoder.encode(c.getClave()));
			Persona  alms= ser.create(c); 
			return new ResponseEntity<>(alms, HttpStatus.CREATED);  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("/{id}")
	public ResponseEntity<Persona> buscar(@PathVariable("id") Long id){
		Optional<Persona> alms= ser.read(id); 
		return alms.map(vale -> new ResponseEntity<>(vale, HttpStatus.OK) )
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	
	@PreAuthorize("hasRole('ADMIN') ")
	@PutMapping("/{id}")
	public ResponseEntity<Persona> editar(@PathVariable("id") Long id, @Valid @RequestBody Persona almas){
		 Optional<Persona> existing = ser.read(id);
	        if (existing.isPresent()) {
	        	// verificar si la contraseña esta encriptada
	        	if (almas.getClave() == null || almas.getClave().isEmpty()) {
	                almas.setClave(existing.get().getClave());
	            } else {
	                // Encriptar la nueva contraseña
	                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	                almas.setClave(passwordEncoder.encode(almas.getClave()));
	            }
	        	
	            almas.setId_persona(id);
	            return new ResponseEntity<>(ser.update(almas), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}
	
	@PreAuthorize("hasRole('ADMIN') ")
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
