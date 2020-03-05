package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public String createdEvent(@Valid @ModelAttribute("event") Event event, BindingResult result) {

		if (result.hasErrors()) {
			return "createevent";
		}

		eventDao.save(event);

		return "redirect:home";
	}

	@GetMapping("/viewEvents")
	public String viewEvents(Model map,HttpSession session) {

		User user = (User)session.getAttribute("user");
		User userD = userDao.findById(user.getId()).get();

		map.addAttribute("userI",userD);
	
		List<Event> events=eventService.getFeatureEvents();

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
	public String joinEvent(Integer userId,Integer eventId, HttpServletRequest request) {

		eventService.subscribeEvent(eventId,userId);
		
		String referer = request.getHeader("Referer");

		return "redirect:" + referer;
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
		map.addAttribute("title", "Your Event List");
		return "yourevents";
	}
	
	@GetMapping("/viewEventDetails")
	public String viewEventDetails(Integer eventId,Integer userId, Model map) {
		
		User userD = userDao.findById(userId).get();
		
		map.addAttribute("userI",userD);
		Event event = eventDao.findById(eventId).get();
		map.addAttribute("event", event);
		return "vieweventdetails";
	}
	
	@GetMapping("/inviteVolunteerList")
	public String inviteVolunteerList(Integer eventId, Model map) {
		List<User> users = eventService.getAllVolunteers();

		map.addAttribute("userList",users);
		map.addAttribute("eventId",eventId);
		return "invitevolunteerlist";
	}
	
	@PostMapping("/inviteVolunteers")
	public String inviteVolunteers(Integer eventId,Integer[] invite) {
		try {
			eventService.inviteVolunteer(eventId, invite);
		}catch(Exception e) {
			
		}
		
		return "redirect:viewEvents";
	}
	
	@GetMapping("/invitedEvents")
	public String invitedEvents(HttpSession session,Model map) {
		User user = (User)session.getAttribute("user");
		User userD = userDao.findById(user.getId()).get();
		
		map.addAttribute("user",userD);
		map.addAttribute("title", "Your Invites");
		Set<Event> events = eventService.getInvitedEvents(user.getId());
		map.addAttribute("events", events);

		return "yourevents";
	}
}
