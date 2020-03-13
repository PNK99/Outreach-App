package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.Event;
import com.bean.User;
import com.service.EventService;
import com.service.FeedbackService;

@Controller
public class MyController {

	@Autowired
	private EventService eventService;
	
	@Autowired
	private FeedbackService feedbackService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/home")
	public String home(Model map, Boolean eventAddCheck, Boolean suggestEventAddCheck, HttpSession session) {

		List<Event> events = eventService.getFutureEvents("", "");
		map.addAttribute("eventAddCheck", eventAddCheck);
		map.addAttribute("suggestEventAddCheck", suggestEventAddCheck);
		User user = (User) session.getAttribute("user");
		map.addAttribute("userId",user.getId());
		map.addAttribute("feedbacks",feedbackService.getFeedbackNotification(user.getId()));
		int length = events.size() >= 5 ? 5 : events.size();

		map.addAttribute("events", events.subList(0, length));
		return "home";

	}

}
