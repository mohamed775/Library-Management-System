package com.globel.library.service;

import java.util.List;

import com.globel.library.entity.Patron;

public interface PatronService {

	// find all patron
	List<Patron> findAll();
	
	// find  patron by id
	Patron findById(Long id);
	
	// get patron By id (if i have instance will retrieve it not return to DB)
	Patron getById(Long id);

	// add patron
	Patron insert(Patron entity);

	// update patron
	Patron update(Patron entity);
	
	// delete patron by id
	void deleteById(Long id);

}
