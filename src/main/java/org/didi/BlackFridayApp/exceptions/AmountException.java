package org.didi.BlackFridayApp.exceptions;

public class AmountException extends Exception {
	private String message;

	public AmountException() {
	}

	public AmountException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return "Invalid sum for quantity";
	}

}
