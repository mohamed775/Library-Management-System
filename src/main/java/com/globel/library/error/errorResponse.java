package com.globel.library.error;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class errorResponse {

	private Boolean success;
	private String message;
	private LocalDateTime dateTime;
	private List<String> details;


	// custom cons for two variable
	public errorResponse(String message, List<String> details) {
		super();
		this.message = message;  // message
		this.details = details;  // details
		this.success = Boolean.FALSE; // static 
		this.dateTime = LocalDateTime.now(); // static 
	}
	
	

}
