package com.globel.library.service;

import com.globel.library.entity.BorrowingRecord;

public interface borrowHandleService {

	// make patron to borrow book
	BorrowingRecord borrowBook(Long bookId ,Long patronId);
	
	//  patron return book
	BorrowingRecord returnBook(Long bookId ,Long patronId);

}
