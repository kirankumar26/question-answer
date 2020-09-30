package com.coding.excercise.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ExcerciseException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(ExcerciseException exception){
		ErrorResponse response=new ErrorResponse();
		response.setMessage(exception.getMessage());
		return new ResponseEntity<ErrorResponse>(response, exception.getHttpStatus());
	
	}
	
	@ExceptionHandler(MissingRequestHeaderException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(MissingRequestHeaderException exception) {
    	ErrorResponse response=new ErrorResponse();
		response.setMessage(exception.getMessage());			
	    return new ResponseEntity<ErrorResponse>(response,HttpStatus.BAD_REQUEST);
	}

}
