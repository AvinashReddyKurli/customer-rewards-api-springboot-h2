package com.customer.rewards.exception;

public class CustomerRewardException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CustomerRewardException() {

	}

	public CustomerRewardException(String message) {
		super(message);
	}

	public CustomerRewardException(Throwable cause) {
		super(cause);
	}

	public CustomerRewardException(String message, Throwable cause) {
		super(message, cause);
	}
}
