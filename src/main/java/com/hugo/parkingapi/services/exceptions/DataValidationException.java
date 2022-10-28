package com.hugo.parkingapi.services.exceptions;

public class DataValidationException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DataValidationException(String msg) {
		super(msg);
	}
	
	public DataValidationException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
