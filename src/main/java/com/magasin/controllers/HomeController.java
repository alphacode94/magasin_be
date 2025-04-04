package com.magasin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	@GetMapping({ "/index", "/admin/index" })
	public String showHome() {
		return null;
	}
}
