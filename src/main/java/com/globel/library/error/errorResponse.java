package com.globel.library.error;

import java.time.LocalDateTime;
import java.util.List;

public class errorResponse {

	private Boolean success;
	private String message;
	private LocalDateTime dateTime;
	private List<String> details;

	public errorResponse() {
		super();
	}

	public errorResponse(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
		this.success = Boolean.FALSE;
		this.dateTime = LocalDateTime.now();
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}
	
	

}
