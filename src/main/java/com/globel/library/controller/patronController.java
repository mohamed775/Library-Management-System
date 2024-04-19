package com.globel.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globel.library.entity.Patron;
import com.globel.library.service.PatronService;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/patrons")
public class patronController {

	// inject PatronService
	@Autowired
	private PatronService patronService ;
	
	
	// find all patrons
	@GetMapping()
	public ResponseEntity<List<Patron>>  findAll() {
		return ResponseEntity.ok(patronService.findAll());
	}
	
	
	// find patron by its id
	@GetMapping("/{id}")
	public ResponseEntity<Patron>  findById(@PathVariable Long id) {
		return ResponseEntity.ok(patronService.findById(id));
	}
	

	// add new patron (not add patron id for this value , its generated auto)
	@PostMapping()
	public ResponseEntity<Patron> insert(@Valid @RequestBody Patron entity) {
		return ResponseEntity.ok(patronService.insert(entity));
	}

	// update patron data based on patronId (put patron id and below data for edit)
	@PutMapping()
	public ResponseEntity<Patron> update(@Valid @RequestBody  Patron entity) {
		return ResponseEntity.ok(patronService.update(entity));
		
	}
	
	// delete patron by id
	@DeleteMapping("/{id}")
	public void deleteById( @PathVariable Long id) {

		patronService.deleteById(id);

	}
}
