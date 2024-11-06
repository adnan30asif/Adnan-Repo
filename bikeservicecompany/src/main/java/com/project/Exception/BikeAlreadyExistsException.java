package com.project.Exception;

public class BikeAlreadyExistsException extends Exception{

	private static final long serialVersionUID = 1L;

	public BikeAlreadyExistsException() {
		super();
	}
	
	public BikeAlreadyExistsException(String message) {
		super(message);
	}
}
