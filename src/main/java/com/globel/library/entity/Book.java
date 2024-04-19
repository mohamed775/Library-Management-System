package com.globel.library.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Table(name ="books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	// must be has at least one char ("a")
    @NotBlank
	private String title;
    
	// must be has at least one char ("a")
    @NotBlank
    private String author;
    
    // not null 
    @NotNull
    private int publicationYear;
    
    @NotBlank
    private String isbn;
    
    
    private boolean isAvilable=true ;


    // specific  constructor 
	public Book(String string, String string2, int i, String string3, boolean b) {
		// TODO Auto-generated constructor stub
	}


    
    
}
