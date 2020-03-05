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
		System.out.println("user=="+user);
		
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
	
	@GetMapping("/viewEventDetails")
	public String viewEventDetails(Integer eventId,Model map) {
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
		System.out.println(eventId);
		System.out.println(invite);
		eventService.inviteVolunteer(eventId, invite);
		
		return "redirect:viewEvents";
	}
}
