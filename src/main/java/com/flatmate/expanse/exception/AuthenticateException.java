package com.flatmate.expanse.exception;

public class AuthenticateException extends Exception {

	/**
	 * @param message
	 * @param cause
	 */
	public AuthenticateException() {
		super("Unable to autherize user. "); 
	}

}
