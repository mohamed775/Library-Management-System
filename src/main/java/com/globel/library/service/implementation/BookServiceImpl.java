package com.globel.library.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.globel.library.entity.Book;
import com.globel.library.error.RecordNotFoundException;
import com.globel.library.repository.BookRepo;
import com.globel.library.service.BookService;

import jakarta.transaction.Transactional;

//@Transactional   --> if i want to apply in all method
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;

	// find all books
	@Override
	@Cacheable(value = "findAllBook",key = "#root.methodName")
	public List<Book> findAll() {
		return bookRepo.findAll();
	}

	// find book by id
	@Override
	@Cacheable(value = "findBookById",key = "#id")
	public Book findById(Long id) {
		Optional<Book> entity = bookRepo.findById(id);
		if (entity.isPresent()) {
			return entity.get();
		} else {
			throw new RecordNotFoundException("book with id:- " + id + "  not found");
		}
	} 

	// find book and not must to retrive it via DB
	@Override
	public Book getById(Long id) {
		return bookRepo.getById(id);
	}

	
	// add new book 
	@Override
	@Transactional
	@CacheEvict(value = {"findAllBook" ,"findBookById"} ,key = "#root.methodName" , allEntries = true)
	public Book insert(Book entity) {
		return bookRepo.save(entity);
	}

	// update  book 
	
	@Override
	@Transactional
//	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 30, readOnly = false)
	@CacheEvict(value = {"findAllBook" ,"findBookById"} ,key = "#root.methodName" , allEntries = true)
	public Book update(Book entity) {
		Book book = bookRepo.getById(entity.getId());

		if (book != null) {
			book.setTitle(entity.getTitle());
			book.setAuthor(entity.getAuthor());
			book.setPublicationYear(entity.getPublicationYear());
			book.setIsbn(entity.getIsbn());

			return bookRepo.save(book);
		}
		return book;

	}

	
	// delete book by id
	@Override
	public void deleteById(Long id) {

		bookRepo.deleteById(id);

	}

	
	// spcific fun to edit book status (book found or not )
	
	@Override
	public void updateAvliableFalse(Long bookId) {

		Book book = bookRepo.findById(bookId).orElse(null);
		if (book != null) {
			book.setAvilable(false);
			update(book);
		}
	}

	@Override
	public void updateAvliableTrue(Long bookId) {
		Book book = bookRepo.findById(bookId).orElse(null);
		if (book != null) {
			book.setId(bookId);
			book.setAvilable(true);
			update(book);
		}
	}

}
