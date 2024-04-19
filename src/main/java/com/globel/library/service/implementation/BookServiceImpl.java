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

	// inject bookRepo
	@Autowired
	private BookRepo bookRepo;

	@Override
	@Cacheable(value = "findAllBook", key = "#root.methodName") // returned data into cache
	public List<Book> findAll() {
		List<Book> books = bookRepo.findAll();
		if (books.isEmpty()) {
			throw new RecordNotFoundException("we not have any books");
		}
		return books;
	}

	@Override
	@Cacheable(value = "findBookById", key = "#id") // returned data into cache
	public Book findById(Long id) {
		Optional<Book> entity = bookRepo.findById(id);
		if (entity.isPresent()) {
			return entity.get();
		} else {
			throw new RecordNotFoundException("book with id:- " + id + "  not found");
		}
	}

	@Override
	public Book getById(Long id) {
		return bookRepo.getById(id);
	}

	@Override
	@Transactional // forRoleBack when any ERROR
	@CacheEvict(value = { "findAllBook", "findBookById" }, key = "#root.methodName", allEntries = true) // clear cache
																										// (update it
																										// with new data
																										// )
	public Book insert(Book entity) {
		return bookRepo.save(entity);
	}

	@Override
	@Transactional // forRoleBack when any ERROR --- ? hash --> @Transactional(propagation =
					// Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 30, readOnly =
					// false)
	@CacheEvict(value = { "findAllBook", "findBookById" }, key = "#root.methodName", allEntries = true) // clear cache
																										// (update it
																										// with new data
																										// )
	public Book update(Book entity) {
		Book book = bookRepo.getById(entity.getId());
		if (book != null) {
			book.setTitle(entity.getTitle());
			book.setAuthor(entity.getAuthor());
			book.setPublicationYear(entity.getPublicationYear());
			book.setIsbn(entity.getIsbn());

			return bookRepo.save(book);
		} else {
			throw new RecordNotFoundException("book  not found");
		}
	}

	// delete book by id
	@Override
	public void deleteById(Long id) {
		Optional<Book> entity = bookRepo.findById(id);
		if (entity.isPresent()) {
			bookRepo.deleteById(id);
		} else {
			throw new RecordNotFoundException("book with id:- " + id + "  not found to deleted");
		}
	}

	// <<< ------- help method ------>>>

	// make book unavailable for borrow
	@Override
	public void updateAvliableFalse(Long bookId) {

		Optional<Book> book = bookRepo.findById(bookId);
		if (book.isPresent()) {
			Book uBook = book.get();
			uBook.setAvilable(false);
			update(uBook);
		}else {
			throw new RecordNotFoundException("book with id : " + bookId +" not found");
		}
	}

	// make book available to borrow
	@Override
	public void updateAvliableTrue(Long bookId) {
		
		Optional<Book> book = bookRepo.findById(bookId);
		if (book.isPresent()) {
			Book uBook = book.get();
			uBook.setId(bookId);
			uBook.setAvilable(true);
			update(uBook);
		}else {
			throw new RecordNotFoundException("book with id : " + bookId +" not found");
		}
	}

}
