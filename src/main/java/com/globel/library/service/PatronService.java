package com.globel.library.service;

import java.util.List;

import com.globel.library.entity.Patron;

public interface PatronService {

	List<Patron> findAll();

	Patron findById(Long id);

	Patron getById(Long id);

	Patron insert(Patron entity);

	Patron update(Patron entity);

	void deleteById(Long id);

}
