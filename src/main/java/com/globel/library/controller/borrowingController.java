package com.globel.library.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globel.library.entity.BorrowingRecord;
import com.globel.library.service.borrowHandleService;

@RestController
@RequestMapping("/api")
public class borrowingController {
	
	// inject borrowHandleService
	@Autowired
	private borrowHandleService borrowHandleService ;
	
	
	// give book to patron and add it in borrow record
	@PostMapping("/borrow/{bookId}/patron/{patronId}")
	public ResponseEntity<BorrowingRecord> borrowBook(@PathVariable Long bookId,@PathVariable Long patronId) {
              return ResponseEntity.ok(borrowHandleService.borrowBook(bookId, patronId));
	}
	
	
	// update borrow record to return date (now) and make book available (another patron can borrow it) 
    @PutMapping("/return/{bookId}/patron/{patronId}")
	public ResponseEntity<BorrowingRecord>  patronReturnBook(@PathVariable Long bookId,@PathVariable Long patronId) {    	
        return ResponseEntity.ok(borrowHandleService.returnBook(bookId, patronId));

	}
	
}
