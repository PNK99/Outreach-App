package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.Event;
import com.dao.EventDao;
import com.service.EventService;

@Controller
public class EventController {

	@Autowired
	private EventDao eventDao;
	
	@Autowired
	private EventService eventService;

	
	@GetMapping("/createEvent")
	public String createEvent(@ModelAttribute("event") Event event) {
		return "createevent";
	}
	
	@PostMapping("/createdEvent")
	public String createdEvent(@ModelAttribute("event") Event event) {
		eventDao.save(event);
		
		System.out.println(event);
		return "redirect:home"; 
	}
	
	@GetMapping("/viewEvents")
	public String viewEvents(Model map) {
		List<Event> events =  eventDao.findAll();
		map.addAttribute("events",events);
		return "viewevents";
	}
	
	@ModelAttribute("activityList")
	public List<String> activityList() {
		List<String> list = new ArrayList<>();
		list.add("weaving");
		list.add("dancing");
		
		return list;
	}
	@GetMapping("/join/{id}")
	public String joinVolunteer(@PathVariable("id") String id) {
		
		eventService.joinVolunteer(Integer.parseInt(id));
		return "redirect:/viewEvents";
	}
	
	@GetMapping("/userEvents")
	public String yourEvents(Model map) {
		Set<Event> events=eventService.getYourEvents();
		map.addAttribute("events",events);
		return "viewevents";
	}
}
