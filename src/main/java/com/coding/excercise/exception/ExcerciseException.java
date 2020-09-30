package com.coding.excercise.exception;

import org.springframework.http.HttpStatus;

public class ExcerciseException extends RuntimeException {	
	private static final long serialVersionUID = 1L;
	private String message;
	private HttpStatus httpStatus;
	
	
	public ExcerciseException(String message) {
		this.message=message;
	}
	
	public ExcerciseException(String message,HttpStatus httpStatus) {
		this.message=message;
		this.httpStatus=httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}


}
