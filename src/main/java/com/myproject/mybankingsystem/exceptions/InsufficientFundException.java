package com.myproject.mybankingsystem.exceptions;

public class InsufficientFundException extends RuntimeException{
	
	public InsufficientFundException(String message) {
		super(message);
	}
}
