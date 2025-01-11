package com.example.Movie.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoSuchMovieExistsException.class)
	public @ResponseBody String noSuchMovieExistsExceptionHandler(NoSuchMovieExistsException exp) {
		return exp.getMessage();
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<String> validation(MethodArgumentTypeMismatchException exp) {
		return new ResponseEntity<>(exp.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}
	
	 @ExceptionHandler(ConstraintViolationException.class)
	 public ResponseEntity<Map<String, List<String>>> handleConstraintViolationException (ConstraintViolationException exp){
	  List<String> error= exp.getConstraintViolations().stream()
	          .map(ConstraintViolation::getMessage).collect(Collectors.toList());

	  return new ResponseEntity<>(getErrorsMap(error), HttpStatus.BAD_REQUEST);
	 }
	
	 private Map<String, List<String>> getErrorsMap(List<String> errors) {
		  Map<String, List<String>> errorResponse = new HashMap<>();
		  errorResponse.put("errors", errors);
		  return errorResponse;
		 }
}
