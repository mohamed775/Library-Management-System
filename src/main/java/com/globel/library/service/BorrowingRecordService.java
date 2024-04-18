package com.globel.library.service;

import com.globel.library.entity.BorrowingRecord; 	
public interface BorrowingRecordService {

	
	
	BorrowingRecord borrow (Long bookId ,Long patronId );
	
	BorrowingRecord findByBookIdAndPatronId (Long bookId ,Long patronId );
	
	boolean AllowPatronBorrow (Long bookId);
	
	void bookReturned (Long bookId );
	
	BorrowingRecord update(BorrowingRecord entity);
	
}
