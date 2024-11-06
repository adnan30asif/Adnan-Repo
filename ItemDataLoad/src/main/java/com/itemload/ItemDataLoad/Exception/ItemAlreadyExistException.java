package com.Khushboo.ItemDataLoad.Exception;

public class ItemAlreadyExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemAlreadyExistException() {
		super();
	}
	
	public ItemAlreadyExistException(String message) {
		super(message);
	}
}
