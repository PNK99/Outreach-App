package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.Event;
import com.bean.User;
import com.dao.EventDao;
import com.dao.UserDao;
import com.service.EventService;

@Controller
public class EventController {

	@Autowired
	private EventDao eventDao;
	

	@Autowired
	private UserDao userDao;

	@Autowired
	private EventService eventService;

	@GetMapping("/createEvent")
	public String createEvent(@ModelAttribute("event") Event event) {
		return "createevent";
	}

	@PostMapping("/createdEvent")
	public String createdEvent(@ModelAttribute("event") Event event) {

		eventDao.save(event);

		return "redirect:home";
	}

	@GetMapping("/viewEvents")
	public String viewEvents(Model map) {

		List<Event> events = eventDao.findAll();

		map.addAttribute("events", events);

		return "viewevents";
	}

	@ModelAttribute("activityList")
	public List<String> activityList() {

		List<String> list = new ArrayList<>();
		list.add("Weaving");
		list.add("Dancing");

		return list;
	}

	@GetMapping("/subscribe")
	public String joinEvent(Integer userId,Integer eventId) {

		eventService.subscribeEvent(eventId,userId);

		return "redirect:/viewEvents";
	}

	@GetMapping("/unsubscribe")
	public String cancelEvent(Integer userId,Integer eventId, HttpServletRequest request) {

		eventService.unsubscribeEvent(eventId,userId);

		String referer = request.getHeader("Referer");

		return "redirect:" + referer;
	}

	@GetMapping("/yourEvents")
	public String yourEvents(Integer userId,Model map) {

		Set<Event> events = eventService.getYourEvents(userId);
		map.addAttribute("events", events);

		return "yourevents";
	}
}
