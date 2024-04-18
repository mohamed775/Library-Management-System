package com.globel.library.service;

import java.util.List;

import com.globel.library.entity.Book;

public interface BookService {

	List<Book> findAll ();
	
	Book findById (Long id);
	
	Book getById(Long id);
	
	Book insert(Book entity);
	
	Book update(Book entity);
	
	void updateAvliableFalse(Long bookId);

	void updateAvliableTrue(Long bookId);

	void deleteById (Long id);	


	
}
