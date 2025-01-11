package com.example.Movie.exception;

public class NoSuchMovieExistsException extends RuntimeException{

	public NoSuchMovieExistsException(String message) {
		super(message);
	}
}
