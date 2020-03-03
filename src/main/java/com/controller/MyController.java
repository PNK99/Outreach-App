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

	
	
	@PostMapping("/go")
	public String reg1(@Valid@ModelAttribute("volunteer")VolunteerDetails d,BindingResult br,ModelMap m) {
		if(br.hasErrors()) {
			return "Registration";
		}
		return "result";
	}
	
	
	
	@GetMapping("/valid")
	public String reg(@ModelAttribute("volunteer")VolunteerDetails d) {
		
		return "Registration";
	}
}
