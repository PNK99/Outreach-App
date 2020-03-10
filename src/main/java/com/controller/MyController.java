package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.Event;
import com.service.EventService;

@Controller
public class MyController {
	
	@Autowired
	private EventService eventService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/home")
	public String home(Model map, Boolean eventAddCheck, Boolean suggestEventAddCheck) {
		
		List<Event> events=eventService.getFutureEvents("","");
		map.addAttribute("eventAddCheck",eventAddCheck);
		map.addAttribute("suggestEventAddCheck",suggestEventAddCheck);
		map.addAttribute("events", events.subList(0, 5));
		return "home";
		
	}

}
