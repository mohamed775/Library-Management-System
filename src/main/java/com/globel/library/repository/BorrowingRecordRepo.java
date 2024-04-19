package com.globel.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globel.library.entity.BorrowingRecord;


@Repository
public interface BorrowingRecordRepo extends JpaRepository<BorrowingRecord, Long> {
	
	//find borrowRecord based on bookId and patronId 
	BorrowingRecord findBorrowingRecordByBookIdAndPatronId (Long bookId , Long patronId);
	
}
