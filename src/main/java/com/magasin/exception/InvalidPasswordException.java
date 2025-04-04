package com.magasin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class InvalidPasswordException extends RuntimeException {

	public InvalidPasswordException(Class clazz, String message) {
		super(InvalidPasswordException.generateMessage(clazz.getSimpleName(), message));
	}

	public InvalidPasswordException(String message) {
		super(message);
	}

	private static String generateMessage(String entity, String message) {
		return StringUtils.capitalize(entity) + " " + message;
	}
}
