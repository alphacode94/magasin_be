package com.magasin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class InvalidGrantException extends RuntimeException {

	public InvalidGrantException(Class clazz, String message) {
		super(InvalidGrantException.generateMessage(clazz.getSimpleName(), message));
	}

	public InvalidGrantException(String message) {
		super(message);
	}

	private static String generateMessage(String entity, String message) {
		return StringUtils.capitalize(entity) + " " + message;
	}
}
