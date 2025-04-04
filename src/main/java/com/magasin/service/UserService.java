package com.magasin.service;

import org.springframework.stereotype.Service;

import com.magasin.dto.UserDTO;

import jakarta.servlet.http.HttpServletRequest;

@Service
public interface UserService extends GenericService<UserDTO> {
	public String signIn(jakarta.servlet.http.HttpServletResponse response, HttpServletRequest request)
			throws Exception;
}
