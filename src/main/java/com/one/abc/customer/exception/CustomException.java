package com.one.abc.customer.exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private int statusCode;
	private String message;

	public CustomException() {
		super();
	}
	
	public CustomException(int statusCode, String message) {
		super(message);
		this.setStatusCode(statusCode);
		this.setMessage(message);
	}
}
