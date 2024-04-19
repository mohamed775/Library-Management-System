package com.globel.library.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.globel.library.entity.BorrowingRecord;
import com.globel.library.service.borrowHandleService;

@SpringBootTest
@AutoConfigureMockMvc
public class borrowControllerTest {
	
	@Autowired
	private borrowingController borrowingController ;

	@MockBean
	private borrowHandleService borrowHandleService;

	@Test
	public void testBorrowBook() throws Exception {

		// Mocking the borrowBook method in borrowHandleService
		BorrowingRecord borrowingRecord = new BorrowingRecord();
		
		// Mock the service response
        Mockito.when(borrowHandleService.borrowBook(anyLong(), anyLong())).thenReturn(borrowingRecord);

        // Perform the update request
        ResponseEntity<BorrowingRecord> responseEntity = borrowingController.borrowBook((long)1, (long)1);

        // Verify that the update method is called with the correct entity
        verify(borrowHandleService).borrowBook(anyLong(), anyLong());

        // Verify that the response entity contains the updated book
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(borrowingRecord, responseEntity.getBody());  


	}

	@Test
	public void testPatronReturnBook() throws Exception {

		// Mocking the returnBook method in borrowHandleService
		BorrowingRecord borrowingRecord = new BorrowingRecord();

		Mockito.when(borrowHandleService.returnBook(anyLong(), anyLong())).thenReturn(borrowingRecord);

		// Perform the update request
        ResponseEntity<BorrowingRecord> responseEntity = borrowingController.patronReturnBook((long)1, (long)1);

        // Verify that the update method is called with the correct entity
        verify(borrowHandleService).returnBook(anyLong(), anyLong());

        // Verify that the response entity contains the updated book
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(borrowingRecord, responseEntity.getBody()); 

	}

}
