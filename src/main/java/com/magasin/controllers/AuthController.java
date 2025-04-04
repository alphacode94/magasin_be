package com.magasin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.magasin.dto.ResponseDTO;
import com.magasin.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	UserService userService;

	@Transactional
	@GetMapping(value = "/login")
	public ResponseEntity<ResponseDTO> signIn(jakarta.servlet.http.HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		String res = userService.signIn(response, request);
		ResponseDTO responseDTO = new ResponseDTO();
		if (res != null) {
			responseDTO = new ResponseDTO("Login Successful", res);
			return new ResponseEntity<>(responseDTO, HttpStatus.CONFLICT);
		} else {
			responseDTO = new ResponseDTO("Login Failed", null);
			return new ResponseEntity<>(responseDTO, HttpStatus.CONFLICT);
		}
	}

}
