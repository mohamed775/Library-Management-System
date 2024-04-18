package com.globel.library.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

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

import com.globel.library.entity.Patron;
import com.globel.library.service.PatronService;

@SpringBootTest
@AutoConfigureMockMvc
public class patronControllerTest {

	@Autowired
	private MockMvc mockMvc;

    @Mock
    private PatronService patronService;

    @InjectMocks
    private patronController patronController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(patronController).build();
    }

	
	@Test
	void testFindAll() throws Exception {
        // Mock the service response
		Patron patron1 = new Patron((long) 1 ,"mohamed","ssdddd5550");
		Patron patron2 = new Patron((long) 2 ,"mostafa","ddddd");

       Mockito.when(patronService.findAll()).thenReturn(Arrays.asList(patron1, patron2));

        // Perform the GET request
        mockMvc.perform(get("/api/patrons"))
               .andExpect(status().isOk());
               
    }
	
	
	@Test
	void testFindById() throws Exception {
        // Mock the service response
        long id = 1L;
        Patron patron = new Patron();
        patron.setId(id);
        Mockito.when(patronService.findById(id)).thenReturn(patron);

        // Perform the GET request
        mockMvc.perform(get("/api/patrons/{id}", id))
               .andExpect(status().isOk());     
    }
	

	@Test
	void testInsert() throws Exception {
		  // Mock the request body
		Patron newPatron = new Patron();
        // Set properties of updatedBook as required for testing

        // Mock the service response
        Mockito.when(patronService.insert(newPatron)).thenReturn(newPatron);

        // Perform the update request
        ResponseEntity<Patron> responseEntity = patronController.insert(newPatron);

        // Verify that the update method is called with the correct entity
        verify(patronService).insert(newPatron);

        // Verify that the response entity contains the updated book
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(newPatron, responseEntity.getBody());    
    }
	

	@Test
	void testUpdate() throws Exception {
		
		  // Mock the request body
		Patron updatedPatron = new Patron();
        // Set properties of updatedBook as required for testing

        // Mock the service response
        Mockito.when(patronService.update(updatedPatron)).thenReturn(updatedPatron);

        // Perform the update request
        ResponseEntity<Patron> responseEntity = patronController.update(updatedPatron);

        // Verify that the update method is called with the correct entity
        verify(patronService).update(updatedPatron);

        // Verify that the response entity contains the updated book
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(updatedPatron, responseEntity.getBody());
	}
	
	
	@Test
	void testDeleteById() throws Exception {

		long id = 1L;
        Patron patron = new Patron();
        patron.setId(id);
        Mockito.when(patronService.findById(id)).thenReturn(patron);
        
        // Perform the GET request
        mockMvc.perform(delete("/api/patrons/{id}", id))
               .andExpect(status().isOk());   
	}
	
}
