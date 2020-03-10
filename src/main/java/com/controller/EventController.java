package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	
	@GetMapping("/suggestEvent")
	public String suggestEvent(@ModelAttribute("event") Event event) {
		return "eventsuggestion";
	}

	@PostMapping("/createdEvent")
	public String createdEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model map) {

		if (result.hasErrors()) {
			return "createevent";
		}
		
		
		event.setApprovalStatus(true);
		eventDao.save(event);
		map.addAttribute("eventAddCheck", true);
		return "redirect:home?eventAddCheck=true";
	}
	
	@PostMapping("/addSuggestEvent")
	public String addSuggestEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model map) {

		if (result.hasErrors()) {
			return "eventsuggestion";
		}

		eventService.addSuggestEvent(event);
		map.addAttribute("suggestEventAddCheck", true);
		return "redirect:home?suggestEventAddCheck=true";
	}

	
	@GetMapping("/viewEvents")
	public String viewEvents(Model map,HttpSession session,@ModelAttribute("eventModel") Event event) {
		
		
		
		
		User user = (User)session.getAttribute("user");
		User userD = userDao.findById(user.getId()).get();

		map.addAttribute("userI",userD);
	//System.out.println(event.getActivity()+" "+event.getPlace());
		
		List<Event> events=eventService.getFutureEvents(event.getActivity(),event.getPlace());

		
		
		map.addAttribute("events", events);

		return "viewevents";
	}
	
	@GetMapping("/viewSuggestedEvents")
	public String viewSuggestedEvents(Model map,HttpSession session,@ModelAttribute("eventModel") Event event) {
		
		
		
		
		User user = (User)session.getAttribute("user");
		User userD = userDao.findById(user.getId()).get();

		map.addAttribute("userI",userD);
	//System.out.println(event.getActivity()+" "+event.getPlace());
		
		List<Event> events=eventService.viewSuggestedEvents(event.getActivity(),event.getPlace());

		
		
		map.addAttribute("events", events);

		return "viewsuggestedevent";
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
	public String yourEvents(Integer userId,Model map,HttpSession session) {
		
		User user = (User)session.getAttribute("user");
		User userD = userDao.findById(user.getId()).get();

		map.addAttribute("userI",userD);
	
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
		
		boolean isToday=eventService.isToday(event.getDate());
		
		map.addAttribute("today",isToday);
		System.out.println(isToday);
		
		return "vieweventdetails";
	}
	
	@GetMapping("/inviteVolunteerList")
	public String inviteVolunteerList(Integer eventId, Integer userId, Model map) {
		List<User> users = eventService.getAllVolunteers(userId);

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
		
		map.addAttribute("userI",userD);
		map.addAttribute("title", "Your Invites");
		Set<Event> events = eventService.getInvitedEvents(user.getId());
		map.addAttribute("events", events);

		return "yourevents";
	}
	
	
	
	@GetMapping("/volunteerAttendance")
	public String volunteerAttendance(Integer eventId, Model map,@ModelAttribute("userModel") User user) {
		
		Set<User> users=eventService.getSubscribedVolunteers(eventId,user.getUserId(),user.getFirstName());
		Event event = eventDao.findById(eventId).get();
		
		map.addAttribute("event",event);
		map.addAttribute("users",users);
		
		return "attendance";
	}
	
	@PostMapping("/attendedVolunteers")
	public String attendedVolunteers(int eventId,Integer[] present) {
		
		eventService.setVolunteerAttendance(eventId, present);
	
		return "redirect:viewEvents";
	}
	
}
