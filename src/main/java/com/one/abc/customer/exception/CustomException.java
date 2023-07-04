package com.one.abc.customer.exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private int statusCode;
	private String message;
	
	

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomException() {
		super();
	}
	
	public CustomException(int statusCode, String message) {
		super(message);
		this.setStatusCode(statusCode);
		this.setMessage(message);
	}
}
