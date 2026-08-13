package com.tcs.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {
	
	@ExceptionHandler(UserNotFoundException.class)
	
	public ResponseEntity<String>userNotFound(UserNotFoundException userNotFoundException){
	return new ResponseEntity<String>(userNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
}

@ExceptionHandler(InvalidOtpException.class)
public ResponseEntity<String>invalidOtp(InvalidOtpException invalidOtpException){
	return new ResponseEntity<String>(invalidOtpException.getMessage(),HttpStatus.BAD_REQUEST);
}

}