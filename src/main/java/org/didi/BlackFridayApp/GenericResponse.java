package org.didi.BlackFridayApp;

public class GenericResponse<T> {
	private T value;

	public GenericResponse(T value) {
		super();
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
