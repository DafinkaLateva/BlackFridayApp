package org.didi.BlackFridayApp.exceptions;

public class AccountException extends Exception {
	private String message;

	public AccountException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return "Not on the right account for this.";
	}
}
