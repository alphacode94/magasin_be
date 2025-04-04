package com.magasin.exception;

import org.springframework.util.StringUtils;

@SuppressWarnings("serial")
public class InvalidArgumentsException extends RuntimeException {

	public InvalidArgumentsException(Class clazz, String message) {
		super(InvalidArgumentsException.generateMessage(clazz.getSimpleName(), message));
	}

	public InvalidArgumentsException(String message) {
		super(message);
	}

	private static String generateMessage(String entity, String message) {
		return StringUtils.capitalize(entity) + ": " + message;
	}
}
