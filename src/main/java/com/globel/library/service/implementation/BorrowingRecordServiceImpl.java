package com.globel.library.service.implementation;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globel.library.entity.Book;
import com.globel.library.entity.BorrowingRecord;
import com.globel.library.repository.BorrowingRecordRepo;
import com.globel.library.service.BookService;
import com.globel.library.service.BorrowingRecordService;
import com.globel.library.service.PatronService;

@Service
public class BorrowingRecordServiceImpl implements BorrowingRecordService {

	@Autowired
	private BorrowingRecordRepo borrowingRecordRepo;

	@Autowired
	private BookService bookService;

	@Autowired
	private PatronService patronService;

	@Override
	public boolean AllowPatronBorrow(Long bookId) {
		Book book = bookService.findById(bookId);
		if (book.isAvilable()) {
			return true;
		} else
			return false;
	}

	@Override
	public void bookReturned(Long bookId) {
		Book book = bookService.findById(bookId);
		book.setAvilable(true);
		bookService.update(book);
	}

	@Override
	public BorrowingRecord borrow(Long bookId, Long patronId) {

		Book book = bookService.findById(bookId);

		if (AllowPatronBorrow(bookId)) {

			bookService.updateAvliableFalse(bookId);
			BorrowingRecord borrowingRecord = new BorrowingRecord();
			borrowingRecord.setBook(book);
			borrowingRecord.setPatron(patronService.findById(patronId));
			borrowingRecord.setBorrowDate(LocalDate.now());

			return borrowingRecordRepo.save(borrowingRecord);
		}
		return null;
	}

	public BorrowingRecord update(BorrowingRecord entity) {

		if (entity != null) {
			entity.setId(entity.getId());
			entity.setReturnDate(LocalDate.now());
		}
		return borrowingRecordRepo.save(entity);
	}

	
	
	public BorrowingRecord findByBookIdAndPatronId(Long bookId , Long patronId) {
		return findByBookIdAndPatronId(bookId , patronId);
	}


}
