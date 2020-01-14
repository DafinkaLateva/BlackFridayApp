package org.didi.BlackFridayApp.exceptions;

public class DiscountException extends Exception {
	private String message;

	public DiscountException() {
	}

	public DiscountException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return "Invalid number for discount";
	}
}
