package org.didi.BlackFridayApp.exceptions;

public class UserException extends Exception {
	private String message;

	public UserException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return "There is no user with this id";
	}
}
