package com.project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = BikeNotFoundException.class)
	public ResponseEntity BikeNotFoundException(BikeNotFoundException ex) {
		String msg=ex.getMessage();
	//	ApiError err=new ApiError(msg);
		return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = BikeAlreadyExistsException.class)
	public ResponseEntity BikeAlreadyExistsException(BikeAlreadyExistsException ex) {
		String msg=ex.getMessage();
		return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
	}

}
