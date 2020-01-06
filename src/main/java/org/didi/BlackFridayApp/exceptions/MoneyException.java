package org.didi.BlackFridayApp.exceptions;

public class MoneyException extends Exception {
	private String message;

	public MoneyException() {
	}

	public MoneyException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return "invalid sum for money";
	}
}