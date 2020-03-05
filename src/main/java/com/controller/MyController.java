package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class MyController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

}
