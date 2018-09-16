package com.flatmate.expanse.exception;

public class AuthenticateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 * @param cause
	 */
	public AuthenticateException() {
		super("Unable to autherize user. "); 
	}

}
