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

import com.globel.library.entity.Book;
import com.globel.library.service.BookService;

import jakarta.validation.Valid;


@Validated
@RestController
@RequestMapping("/api/books")
public class bookController {

	@Autowired
	private BookService bookService ;
	
	
	@GetMapping()
	public ResponseEntity<List<Book>>  findAll() {
		return ResponseEntity.ok(bookService.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Book>  findById(@PathVariable Long id) {
		return ResponseEntity.ok(bookService.findById(id));
	}
	

	
	@PostMapping()
	public ResponseEntity<Book> insert(@Valid @RequestBody Book entity) {
		return ResponseEntity.ok(bookService.insert(entity));
	}

	
	@PutMapping()
	public ResponseEntity<Book> update(@Valid @RequestBody  Book entity) {
		return ResponseEntity.ok(bookService.update(entity));
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteById( @PathVariable Long id) {

		bookService.deleteById(id);

	}
	
}
