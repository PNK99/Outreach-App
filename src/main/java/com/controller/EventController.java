package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.bean.Activity;
import com.bean.Event;
import com.bean.User;
import com.dao.ActivityDao;
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

	@Autowired
	private ActivityDao activityDao;

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

		System.out.println("Activity:" + event.getActivityType());

		System.out.println(result.getAllErrors());
		if (result.hasErrors()) {
			return "createevent";
		}

		event.setApprovalStatus(true);


		eventDao.save(event);
		map.addAttribute("eventAddCheck", true);
		return "redirect:home?eventAddCheck=true";
	}

	@PostMapping("/addSuggestEvent")
	public String addSuggestEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model map,
			Integer userId) {

		if (result.hasErrors()) {
			return "eventsuggestion";
		}

		eventService.addSuggestEvent(event, userId);
		map.addAttribute("suggestEventAddCheck", true);
		return "redirect:home?suggestEventAddCheck=true";
	}

	@GetMapping("/viewEvents")
	public String viewEvents(Model map, HttpSession session, @ModelAttribute("eventModel") Event event) {

			User user = (User) session.getAttribute("user");
			User userD = userDao.findById(user.getId()).get();

			map.addAttribute("userI", userD);

			String activity = event.getActivityType() == null ? "" : event.getActivityType().getName();

			List<Event> events = eventService.getFutureEvents(activity, event.getPlace());

			map.addAttribute("events", events);

			return "viewevents";

	}

	@GetMapping("/viewSuggestedEvents")
	public String viewSuggestedEvents(Model map, HttpSession session, @ModelAttribute("eventModel") Event event, String eventApproved) {

		User user = (User) session.getAttribute("user");
		User userD = userDao.findById(user.getId()).get();

		map.addAttribute("userI", userD);

		String activity = event.getActivityType() == null ? "" : event.getActivityType().getName();
		List<Event> events = eventService.viewSuggestedEvents(activity, event.getPlace());

		map.addAttribute("events", events);
		map.addAttribute("eventApproved",eventApproved != null);
		return "viewsuggestedevent";
	}

	public Map<Integer, String> user() {
		List<Activity> activities = activityDao.findAll();
		Map<Integer, String> activityMap = new HashMap<>();

		for (Activity activity : activities) {
			activityMap.put(activity.getId(), activity.getName());
		}

		return activityMap;
	}

	@GetMapping("/subscribe")
	public String joinEvent(Integer userId, Integer eventId, HttpServletRequest request) {

		eventService.subscribeEvent(eventId, userId);

		String referer = request.getHeader("Referer");

		return "redirect:" + referer;
	}

	@GetMapping("/unsubscribe")
	public String cancelEvent(Integer userId, Integer eventId, HttpServletRequest request) {

		eventService.unsubscribeEvent(eventId, userId);

		String referer = request.getHeader("Referer");

		return "redirect:" + referer;
	}

	@GetMapping("/yourEvents")
	public String yourEvents(Integer userId, Model map, HttpSession session) {

		User user = (User) session.getAttribute("user");
		User userD = userDao.findById(user.getId()).get();

		map.addAttribute("userI", userD);

		Set<Event> events = eventService.getYourEvents(userId);
		map.addAttribute("events", events);
		map.addAttribute("title", "Your Event List");
		return "yourevents";
	}

	@GetMapping("/viewEventDetails")
	public String viewEventDetails(Integer eventId, Integer userId, Model map) {
	
		User userD = userDao.findById(userId).get();

		map.addAttribute("userI", userD);
		Event event = eventDao.findById(eventId).get();
		map.addAttribute("event", event);

		boolean isToday = eventService.isToday(event.getDate());

		map.addAttribute("today", isToday);
		System.out.println(isToday);

		return "vieweventdetails";
	}

	@GetMapping("/inviteVolunteerList")
	public String inviteVolunteerList(Integer eventId, Integer userId, Model map) {
		List<User> users = eventService.getAllVolunteers(userId);

		map.addAttribute("userList", users);
		map.addAttribute("eventId", eventId);
		return "invitevolunteerlist";
	}

	@PostMapping("/inviteVolunteers")
	public String inviteVolunteers(Integer eventId, Integer[] invite) {
		try {
			eventService.inviteVolunteer(eventId, invite);
		} catch (Exception e) {

		}

		return "redirect:viewEvents";
	}

	@GetMapping("/invitedEvents")
	public String invitedEvents(HttpSession session, Model map) {
		User user = (User) session.getAttribute("user");
		User userD = userDao.findById(user.getId()).get();

		map.addAttribute("userI", userD);
		map.addAttribute("title", "Your Invites");
		Set<Event> events = eventService.getInvitedEvents(user.getId());
		map.addAttribute("events", events);

		return "yourevents";
	}

	@GetMapping("/volunteerAttendance")
	public String volunteerAttendance(Integer eventId, Model map, @ModelAttribute("userModel") User user) {

		Set<User> users = eventService.getSubscribedVolunteers(eventId, user.getUserId(), user.getFirstName());
		Event event = eventDao.findById(eventId).get();

		map.addAttribute("event", event);
		map.addAttribute("users", users);

		return "attendance";
	}

	@PostMapping("/attendedVolunteers")
	public String attendedVolunteers(int eventId, Integer[] present) {

		eventService.setVolunteerAttendance(eventId, present);

		return "redirect:viewEvents";
	}

	@GetMapping("/eventApproved")
	public String eventApproved(HttpServletRequest request, Integer eventId) {

		eventService.eventApproved(eventId);

		String referer = request.getHeader("Referer");


		return "redirect:" + referer +"?eventApproved=true";
	}

	
	@GetMapping("/eventRejected")
	public String eventRejected(HttpServletRequest request, Integer eventId) {

		eventService.eventRejected(eventId);

		String referer = request.getHeader("Referer");

		return "redirect:" + referer;
	}
	
}
