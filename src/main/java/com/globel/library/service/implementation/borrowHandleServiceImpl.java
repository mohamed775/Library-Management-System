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

import jakarta.transaction.Transactional;

@Service
public class borrowHandleServiceImpl implements borrowHandleService {

	@Autowired
	private BorrowingRecordRepo borrowingRecordRepo;

	@Autowired
	private BookService BookService;
	@Autowired
	private PatronService patronService;

	@Override
	@Transactional
	public BorrowingRecord borrowBook(Long bookId, Long patronId) {

		Book book = BookService.findById(bookId);

		if (AllowPatronBorrow(bookId)) {

			BookService.updateAvliableFalse(bookId);
			BorrowingRecord borrowingRecord = new BorrowingRecord();
			borrowingRecord.setBook(book);
			borrowingRecord.setPatron(patronService.findById(patronId));
			borrowingRecord.setBorrowDate(LocalDate.now());

			return borrowingRecordRepo.save(borrowingRecord);

		} else
			throw new bookHasBorrowed("book with id " + bookId + "  has been borrowed");
	}

	@Override
	@Transactional
	public BorrowingRecord returnBook(Long bookId, Long patronId) {

		BorrowingRecord record = borrowingRecordRepo.findBorrowingRecordByBookIdAndPatronId(bookId, patronId);
		if (record == null ) {
			throw new RecordNotFoundException("record not found check bookID : " + bookId + " and patronId : " + patronId);
		} else {
			BookService.updateAvliableTrue(bookId);
			record.setId(record.getId());
			record.setReturnDate(LocalDate.now());
			return  borrowingRecordRepo.save(record) ;
		}

	}

	
	
	/////////////////////////////////// help fun

	public boolean AllowPatronBorrow(Long bookId) {
		Book book = BookService.findById(bookId);
		if (book.isAvilable()) {
			return true;
		} else
			return false;
	}

	public void bookReturned(Long bookId) {
		Book book = BookService.findById(bookId);
		book.setId(bookId);
		book.setAvilable(true);
		BookService.update(book);
	}

}
