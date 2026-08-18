package com.tcs.ems.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> invalidData(MethodArgumentNotValidException exception) {

        Map<String, String> message = new HashMap<>();

        List<FieldError> errors = exception.getBindingResult().getFieldErrors();

        for (FieldError fe : errors) {
            message.put(fe.getField(), fe.getDefaultMessage());
        }

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> userNotFound(UserNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidOtpException.class)
    public ResponseEntity<String> invalidOtp(InvalidOtpException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OtpVerifiedException.class)
    public ResponseEntity<String> otpVerified(OtpVerifiedException otpVerifiedException) {
        return new ResponseEntity<>(otpVerifiedException.getMessage(), HttpStatus.OK);
    }

    @ExceptionHandler(OtpExpiredException.class)
    public ResponseEntity<String> otpExpired(OtpExpiredException otpExpiredException) {
        return new ResponseEntity<>(otpExpiredException.getMessage(), HttpStatus.GONE);
    }

    @ExceptionHandler(OtpAlreadyVerified.class)
    public ResponseEntity<String> otpAlreadyVerified(OtpAlreadyVerified otpAlreadyVerified) {
        return new ResponseEntity<>(otpAlreadyVerified.getMessage(), HttpStatus.ACCEPTED);
    }
}
