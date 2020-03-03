package com.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.VolunteerDetails;

@Controller
public class MyController {

	
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	
	@GetMapping("/valid")
	public String reg(@ModelAttribute("volunteer")VolunteerDetails d,BindingResult br,ModelMap m) {
		
		return "Registration";
	}
}
