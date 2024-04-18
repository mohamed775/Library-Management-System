package com.globel.library.service;

import com.globel.library.entity.BorrowingRecord;

public interface borrowHandleService {

	BorrowingRecord borrowBook(Long bookId ,Long patronId);
	
	BorrowingRecord returnBook(Long bookId ,Long patronId);

}
