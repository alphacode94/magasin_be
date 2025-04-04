package com.magasin.exception;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiError {

	int code;
	HttpStatus status;
	String responseMessage;
	String debugMessage;
	String path;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	Date timestamp;
	List<String> errors;
	String stackTrace;

	ApiError() {

	}

	ApiError(HttpStatus status) {
		this.status = status;
	}

	ApiError(HttpStatus status, Throwable ex) {
		this.status = status;
		this.responseMessage = "Unexpected error";
		this.debugMessage = ex.getLocalizedMessage();
		ex.printStackTrace();

	}

	ApiError(HttpStatus status, int code, Throwable ex, String path) {
		this.status = status;
		this.code = code;
		this.code = status.value();
		this.path = path;
	}

	public ApiError(HttpStatus status, String message, List<String> errors) {
		super();
		this.status = status;
		this.responseMessage = message;
		this.errors = errors;
	}

	public ApiError(HttpStatus status, String message, String error) {
		super();
		this.status = status;
		this.responseMessage = message;
		errors = Arrays.asList(error);
	}

	ApiError(HttpStatus status, String message, Throwable ex) {
		this();
		this.status = status;
		this.responseMessage = message;
		this.debugMessage = ex.getLocalizedMessage();
		ex.printStackTrace();

	}

	public ApiError(HttpStatus status, int code, String message, String path) {
		this.status = status;
		this.code = code;
		this.responseMessage = message;
		this.path = path;

	}

	public ApiError(HttpStatus status, int code, String message, String path, Date timestamp, String debugMessage) {
		this.status = status;
		this.code = code;
		this.responseMessage = message;
		this.path = path;
		this.timestamp = timestamp;
		this.debugMessage = debugMessage;

	}

	public ApiError(HttpStatus status, int code, String message, String path, Date timestamp, String debugMessage,
			Exception ex) {
		this.status = status;
		this.code = code;
		this.responseMessage = message;
		this.path = path;
		this.timestamp = timestamp;
		this.debugMessage = debugMessage;
		ex.printStackTrace();

	}

}
