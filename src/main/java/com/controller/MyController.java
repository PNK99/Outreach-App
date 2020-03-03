package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.VolunteerDetails;
import com.service.RolesService;

@Controller
public class MyController {

	@Autowired
	private RolesService service;
	
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/valid")
	public String reg(@ModelAttribute("volunteer")VolunteerDetails d) {
		
		return "registration";
	}
	
	@ModelAttribute("type")  
	public Map<Integer,String> user(){
		Map<Integer,String> m=service.getRolesList();
		
		return m;
	}
	
	
}
