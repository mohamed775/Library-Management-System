package com.globel.library.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name ="books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
    @NotBlank
	private String title;
	
    @NotBlank
    private String author;
    
    @NotNull
    @Min(value = 5)
    @Max(value = 10)
    private int publicationYear;
    
    @NotBlank
    private String isbn;
    
    private boolean isAvilable=true ;


    
    
}
