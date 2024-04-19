package com.globel.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patrons")
public class Patron {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	// must be has at least one char ("a")
    @NotBlank
	private String name;
	
    
	// must be has at least one char ("a")
    @NotBlank
	private String contactInformation;	

}
