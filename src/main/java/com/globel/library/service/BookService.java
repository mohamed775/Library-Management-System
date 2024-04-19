package com.globel.library.service;

import java.util.List;

import com.globel.library.entity.Book;

public interface BookService {

	// find all book
	List<Book> findAll ();
	
	// find book By id
	Book findById (Long id);

	// get book By id (if i have instance will retrieve it not return to DB)
	Book getById(Long id);
	
	// add book
	Book insert(Book entity);
	
	//update book
	Book update(Book entity);
	
	// delete book
	void deleteById (Long id);	

	
	// << ----- help method ------->>
	
	// when patron borrow this book  (book not avail)
	void updateAvliableFalse(Long bookId);

	// when patron return  book  (book make it avail)
	void updateAvliableTrue(Long bookId);

	
}
