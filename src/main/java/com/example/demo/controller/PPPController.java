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
import com.example.demo.entity.PPP;
import com.example.demo.service.PPPService;

import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ppp")
@CrossOrigin(origins = "http://localhost:4200")

public class PPPController {

	@Autowired
	private PPPService ser;
	
	@Autowired
	private EntityManager entityManager;

	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping
	public ResponseEntity<List<PPP>> listar(){
		try {
			List<PPP> alma= ser.readAll(); 
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
	public ResponseEntity<PPP> crear(@Valid @RequestBody PPP c){
		try {
			PPP  alms= ser.create(c); 
			return new ResponseEntity<>(alms, HttpStatus.CREATED);  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("/{id}")
	public ResponseEntity<PPP> buscar(@PathVariable("id") Long id){
		Optional<PPP> alms= ser.read(id); 
		return alms.map(vale -> new ResponseEntity<>(vale, HttpStatus.OK) )
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@PutMapping("/{id}")
	public ResponseEntity<PPP> editar(@PathVariable("id") Long id, @Valid @RequestBody PPP almas){
		 Optional<PPP> existing = ser.read(id);
	        if (existing.isPresent()) {
	            almas.setId_ppp(id);
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
	


	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("/persona/{id}")
	public ResponseEntity<List<PPP>> getPPPsByPersona(@PathVariable Long id) {
		String jpql = "SELECT p " +
	              "FROM Carrera_Persona cp " +
	              "JOIN cp.ppps p " +
	              "WHERE cp.id_carrera_persona = :id";

	    List<PPP> ppps = entityManager.createQuery(jpql, PPP.class)
	                                  .setParameter("id", id)
	                                  .getResultList();
	    if (ppps.isEmpty()) {
	        return ResponseEntity.noContent().build();
	    }
	    return ResponseEntity.ok(ppps);
	}
	

	
	
	
	
	
}
