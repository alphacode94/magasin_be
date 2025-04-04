package com.magasin.config;

public class SecurityConstants {

	public static final String JWT_SECRET = "t3pCSx2wx1ExbQ5z43XXB8my/KR24aon4EH/niU9iZi1I3S69rk1QhlMFFsTrZIY";
	// public static final long EXPIRATION_TIME = 36_000_000; // 10 hours
	// public static final long EXPIRATION_TIME = 31556952000l; // 1 year
	public static final long EXPIRATION_TIME = 18000000; // 5 hour
	public static final int EXPIRY_DAY = 3;
	public static final String BEARER_TOKEN_PREFIX = "Bearer ";
	public static final String BASIC_TOKEN_PREFIX = "Basic ";
	public static final String AUTH_HEADER = "Authorization";
	public static final String SIGN_IN_URI_ENDING = "/signin";
	public static final String REALM_HEADER = "WWW-Authenticate";
	public static final String VALIDATE_OTP_URI_ENDING = "/validate_otp";
}
