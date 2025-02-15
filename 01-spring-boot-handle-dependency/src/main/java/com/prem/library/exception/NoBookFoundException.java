package com.prem.library.exception;

public class NoBookFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoBookFoundException() {
		super();
	}
	public NoBookFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
