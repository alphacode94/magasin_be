package com.magasin.utils;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.magasin.config.SecurityConstants;
import com.magasin.models.Users;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class TokenUtils {

	@Autowired
	private static HttpServletRequest request;

	private TokenUtils(HttpServletRequest request) {
		TokenUtils.request = request;
	}

	private static Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(SecurityConstants.JWT_SECRET),
			SignatureAlgorithm.HS512.getJcaName());

	/*
	 * public static String generateJWTUserToken(String userName) { // String
	 * username = authentication.getName(); Date currentDate = new Date(); Date
	 * expireDate = new Date(currentDate.getTime() +
	 * SecurityConstants.EXPIRATION_TIME); Map<String, Object> additionalInfo = new
	 * HashMap<String, Object>(); additionalInfo.put("id", "2346545");
	 * 
	 * String token = Jwts.builder().setSubject(userName).setIssuedAt(new
	 * Date()).setExpiration(expireDate) .addClaims(additionalInfo) //
	 * .signWith(null, null) .signWith(hmacKey) //
	 * .signWith(SignatureAlgorithm.HS512, SecurityConstants.JWT_SECRET) .compact();
	 * return token; }
	 */

	public static String generateJWTUserToken(Users userAccount, String clientIp) {
		String userName = userAccount.getUsername();
		Date currentDate = new Date();
		Date expireDate = new Date(currentDate.getTime() + SecurityConstants.EXPIRATION_TIME);
		Map<String, Object> additionalInfo = new HashMap<String, Object>();
		additionalInfo.put("active", userAccount.isActive());
		additionalInfo.put("userId", userAccount.getId());
		additionalInfo.put("clientIp", clientIp);

		if (userAccount.getPermissions() != null) {
			additionalInfo.put("permissions", userAccount.getPermissions());
		}

		String token = Jwts.builder().setSubject(userName).setIssuedAt(new Date()).setExpiration(expireDate)
				.addClaims(additionalInfo)
				// .signWith(null, null)
				.signWith(hmacKey)
				// .signWith(SignatureAlgorithm.HS512, SecurityConstants.JWT_SECRET)
				.compact();
		return token;
	}

	public static String generateJWTUserTokenWithDetails() {
		String userName = ""; // authentication.getName();
		Date currentDate = new Date();
		Date expireDate = new Date(currentDate.getTime() + SecurityConstants.EXPIRATION_TIME);

		String token = Jwts.builder().setSubject(userName).setIssuedAt(new Date()).setExpiration(expireDate)
				// .signWith(null, null)
				.signWith(hmacKey)
				// .signWith(SignatureAlgorithm.HS512, SecurityConstants.JWT_SECRET)
				.compact();
		return token;
	}

	public static String getFieldFromToken(String field) {
		if (request.getHeader("Authorization") == null) {
			return null;
		}
		String token = request.getHeader("Authorization").replace("Bearer", "").trim();
		Claims claims = Jwts.parser().setSigningKey(hmacKey).parseClaimsJws(token).getBody();
		// get value from token
		return claims.get(field).toString();
	}

	public static String getSessionIdFromToken() {
		if (request.getHeader("Localsessionid") == null) {
			return "";
		}
		String token = request.getHeader("Localsessionid").trim();
		return token;
	}

	public static String getUsernameFromJWTUserToken(String token) {
		// Claims claims = Jwts.parser()
		// .setSigningKey(SecurityConstants.JWT_SECRET)
		// .parseClaimsJws(token)
		// .getBody();
		Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(hmacKey).build().parseClaimsJws(token);

		return claims.getBody().getSubject();
	}

	public static boolean isJWTTokenValid(String token) throws AuthenticationException {
		try {
			// Jwts.parser().setSigningKey(SecurityConstants.JWT_SECRET).parseClaimsJws(token);
			Jwts.parserBuilder().setSigningKey(hmacKey).build().parseClaimsJws(token);
			return true;
		} catch (Exception ex) {
			throw new AuthenticationException("JWT was expired or incorrect");
		}
	}

	public static String[] decodedBase64(String token) {

		byte[] decodedBytes = Base64.getDecoder().decode(token);
		String pairedCredentials = new String(decodedBytes);
		String[] credentials = pairedCredentials.split(":", 2);

		return credentials;

	}

	public static String decodeBase64String(String base64String) {

		byte[] decodedBytes = Base64.getDecoder().decode(base64String);
		String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
		return decodedString;
	}

}
