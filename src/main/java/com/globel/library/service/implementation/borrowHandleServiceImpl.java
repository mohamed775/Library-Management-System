package com.globel.library.service.implementation;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.globel.library.entity.Book;
import com.globel.library.entity.BorrowingRecord;
import com.globel.library.entity.Patron;
import com.globel.library.error.RecordNotFoundException;
import com.globel.library.error.bookHasBorrowed;
import com.globel.library.repository.BorrowingRecordRepo;
import com.globel.library.service.BookService;
import com.globel.library.service.PatronService;
import com.globel.library.service.borrowHandleService;

@Service
public class borrowHandleServiceImpl implements borrowHandleService {

	@Autowired
	private BorrowingRecordRepo borrowingRecordRepo;

	@Autowired
	private BookService BookService;
	private PatronService patronService;

	
	@Override
	public BorrowingRecord borrowBook(Long bookId, Long patronId) {

		Book book = BookService.findById(bookId);
		Patron patron = patronService.findById(patronId);

		if (book != null && patron != null) {
			if (AllowPatronBorrow(book)) {
				BorrowingRecord borrowingRecord = new BorrowingRecord();
				borrowingRecord.setBook(book);
				borrowingRecord.setPatron(patron);
				borrowingRecord.setBorrowDate(LocalDate.now());
				borrowingRecordRepo.save(borrowingRecord);
				BookService.updateAvliableFalse(bookId);
				return borrowingRecord;
			} else 
				throw new bookHasBorrowed("book with id " + bookId + "has been borrowed");
			
		} else
			throw new RecordNotFoundException("book with id:- " + bookId + " or patron with id  " + patronId + "  not found");
	}

	@Override
	public BorrowingRecord returnBook(Long bookId, Long patronId) {
		return null;
	}
	
	
	
	public boolean AllowPatronBorrow(Book book) {
		if (book.isAvilable()) {
			return true;
		} else
			return false;
	}
	
	public void bookReturned(Book book) {
		book.setAvilable(true);
		BookService.update(book);
	}

}
