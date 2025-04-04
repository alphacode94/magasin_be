package com.magasin.exception;

@SuppressWarnings("serial")
public class SqlException extends RuntimeException {

	public SqlException(String message) {
		super(message);
	}
}
