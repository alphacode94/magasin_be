package com.magasin.exception;

@SuppressWarnings("serial")
public class TypeNotFoundException extends RuntimeException {

	public TypeNotFoundException(String message) {
		super(message);
	}
}
