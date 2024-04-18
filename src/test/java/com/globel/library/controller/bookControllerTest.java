package com.globel.library.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.globel.library.entity.Book;
import com.globel.library.service.BookService;

@SpringBootTest
@AutoConfigureMockMvc
public class bookControllerTest {

	
	@Autowired
	private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @InjectMocks
    private bookController bookController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

	
	@Test
	void testFindAll() throws Exception {
        // Mock the service response
		Book book1 = new Book((long) 1 ,"magic","ramy",2019,"ssdddd5550", true);
		Book book2 = new Book((long)2 ,"mag","vvv",2015,"vvv", true);

       Mockito.when(bookService.findAll()).thenReturn(Arrays.asList(book1, book2));

        // Perform the GET request
        mockMvc.perform(get("/api/books"))
               .andExpect(status().isOk());
               
    }
	
	
	@Test
	void testFindById() throws Exception {
        // Mock the service response
        long id = 1L;
        Book book = new Book();
        book.setId(id);
        Mockito.when(bookService.findById(id)).thenReturn(book);


        // Perform the GET request
        mockMvc.perform(get("/api/books/{id}", id))
               .andExpect(status().isOk());     
    }
	

	@Test
	void testInsert() throws Exception {
		  // Mock the request body
        Book newBook = new Book();
        // Set properties of updatedBook as required for testing

        // Mock the service response
        Mockito.when(bookService.insert(newBook)).thenReturn(newBook);

        // Perform the update request
        ResponseEntity<Book> responseEntity = bookController.insert(newBook);

        // Verify that the update method is called with the correct entity
        verify(bookService).insert(newBook);

        // Verify that the response entity contains the updated book
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(newBook, responseEntity.getBody());    
    }
	

	@Test
	void testUpdate() throws Exception {
		
		  // Mock the request body
        Book updatedBook = new Book();
        // Set properties of updatedBook as required for testing

        // Mock the service response
        Mockito.when(bookService.update(updatedBook)).thenReturn(updatedBook);

        // Perform the update request
        ResponseEntity<Book> responseEntity = bookController.update(updatedBook);

        // Verify that the update method is called with the correct entity
        verify(bookService).update(updatedBook);

        // Verify that the response entity contains the updated book
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(updatedBook, responseEntity.getBody());
	}
	
	
	@Test
	void testDeleteById() throws Exception {

		long id = 1L;
        Book book = new Book();
        book.setId(id);
        Mockito.when(bookService.findById(id)).thenReturn(book);
        
        // Perform the GET request
        mockMvc.perform(delete("/api/books/{id}", id))
               .andExpect(status().isOk());   
	}
	
}
