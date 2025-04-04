package com.magasin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

	public EntityNotFoundException(Class clazz, String message) {
		super(EntityNotFoundException.generateMessage(clazz.getSimpleName(), message));
	}

	public EntityNotFoundException(String message) {
		super(message);
	}

	private static String generateMessage(String entity, String message) {
		return StringUtils.capitalize(entity) + ": " + message;
	}
}
