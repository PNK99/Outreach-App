package com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Event;
import com.bean.User;
import com.dao.EventDao;
import com.dao.UserDao;

@Service
public class EventService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private EventDao eventDao;

	public Boolean addSuggestEvent(Event event, Integer userId) {

		try {

			event.setApprovalStatus(false);
			User user = userDao.findById(userId).get();
			event.setSuggestedVolunteer(user);
			eventDao.save(event);

		} catch (Exception e) {
			return false;
		}

		return true;

	}

	/*
	 * public Boolean addEvent(Event event) {
	 * 
	 * return true; }
	 * 
	 * public List<Event> showApprovedEvents() { return
	 * eventDao.getApprovedEvents(); }
	 */

	public List<Event> viewSuggestedEvents(String activity, String place) {

		List<Event> events = eventDao.findAll();

		List<Event> futureEvents = new ArrayList<>();

		Date date = new Date();

		for (Event event : events) {
			long diff = event.getDate().getTime() - date.getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000);
			if (diffDays >= 0 && !event.getApprovalStatus()) {
				if (activity == null
						|| event.getActivityType().getName().toLowerCase().contains(activity.toLowerCase())) {
					if (place == null || event.getPlace().toLowerCase().contains(place.toLowerCase())) {
						futureEvents.add(event);
					}
				}

			}
		}

		return futureEvents;

	}

	public List<Event> getFutureEvents(String activity, String place) {

		List<Event> events = eventDao.findAll();
		System.out.println(events+"HJ");

		List<Event> futureEvents = new ArrayList<>();

		Date date = new Date();

		for (Event event : events) {
			long diff = event.getDate().getTime() - date.getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000);

			if (diffDays >= 0 && diffDays < 15 && event.getApprovalStatus()) {

				if (activity == null
						|| event.getActivityType().getName().toLowerCase().contains(activity.toLowerCase())) {
					if (place == null || event.getPlace().toLowerCase().contains(place.toLowerCase())) {
						futureEvents.add(event);
					}
				}

			}
		}
		System.out.println(events);
		System.out.println(futureEvents);
		return futureEvents;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public EventDao getEventDao() {
		return eventDao;
	}

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	public boolean subscribeEvent(Integer eventId, Integer userId) {

		boolean result = true;

		try {
			Optional<User> userOp = userDao.findById(userId);
			Optional<Event> eventOp = eventDao.findById(eventId);

			User user = userOp.get();
			Event event = eventOp.get();

			event.getVolunteers().add(user);

			eventDao.save(event);

		} catch (Exception e) {
			result = false;
		}

		return result;
	}

	public Set<Event> getYourEvents(Integer userId) {

		Set<Event> listOfEvents = null;

		if (userId != null) {
			Optional<User> user = userDao.findById(userId);
			listOfEvents = user.get().getEvents();
		}

		return listOfEvents;

	}

	public boolean unsubscribeEvent(Integer eventId, Integer userId) {

		boolean result = true;

		try {

			Optional<User> userOp = userDao.findById(userId);
			Optional<Event> eventOp = eventDao.findById(eventId);

			User user = userOp.get();
			Event event = eventOp.get();

			event.getVolunteers().remove(user);
			eventDao.save(event);
		} catch (Exception e) {
			result = false;
		}

		return result;

	}

	public List<User> getAllVolunteers(Integer userId) {
		List<User> users = null;

		if (userId != null)
			users = userDao.findAllVolunteers(userId);

		return users;
	}

	public boolean inviteVolunteer(int eventId, Integer ids[]) {

		boolean result = true;

		try {
			Event event = eventDao.findById(eventId).get();

			for (Integer id : ids) {
				User user = userDao.findById(id).get();
				event.getInvitedPeople().add(user);
			}
			eventDao.save(event);

		} catch (Exception e) {
			result = false;
		}

		return result;

	}

	public Set<Event> getInvitedEvents(Integer userId) {

		Set<Event> events = null;

		if (userId != null) {

			User user = userDao.findById(userId).get();
			events = user.getInvitedEvents();

		}
		return events;
	}

	public Set<User> getSubscribedVolunteers(Integer eventId, Integer userId, String firstName) {

		Set<User> users = null;

		Set<User> filteredUser = new HashSet<>();

		if (eventId != null) {

			Event event = eventDao.findById(eventId).get();
			users = event.getVolunteers();
		}

		if (userId != null || firstName != null) {
			for (User user : users) {

				if (user.getUserId() == userId && user.getFirstName().contains(firstName)) {
					filteredUser.add(user);
					break;
				} else if (user.getFirstName().contains(firstName) && userId == null) {
					filteredUser.add(user);
				}

			}

		} else
			filteredUser = users;

		return filteredUser;
	}

	public boolean setVolunteerAttendance(Integer eventId, Integer userIds[]) {
		boolean result = true;
		Event event = null;
		Double eventPoints;
		try {
			event = eventDao.findById(eventId).get();

			eventPoints = event.getActivityType().getPoints();

			for (User volunteer : event.getVoluteerPresent()) {
				Double currentPoints = volunteer.getWahPoints();
				volunteer.setWahPoints(currentPoints - eventPoints);
				userDao.save(volunteer);

			}

			event.getVoluteerPresent().clear();

			if (userIds == null)
				eventDao.save(event);

			for (Integer id : userIds) {

				User user = userDao.findById(id).get();
				Double currentPoints = user.getWahPoints();

				user.setWahPoints(currentPoints + eventPoints);
				System.out.println(user);
				userDao.save(user);

				event.getVoluteerPresent().add(user);
				System.out.println("set:" + user.getWahPoints());
			}
			eventDao.save(event);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result = false;
		}

		return result;
	}

	public boolean isToday(Date eventDate) {

		Date date = new Date();

		long diff = eventDate.getTime() - date.getTime();

		long diffHours = diff / (60 * 60 * 1000);
		System.out.println(diffHours);
		if (diffHours >= -12 && diffHours < 12) {
			return true;
		}
		return false;

	}

	public boolean eventApproved(Integer eventId) {

		try {

			Event event = eventDao.findById(eventId).get();
			event.setApprovalStatus(true);
			eventDao.save(event);
			return true;

		}

		catch (Exception e) {
			return false;
		}
	}

	public boolean eventRejected(Integer eventId) {

		try {

			Event event = eventDao.findById(eventId).get();
			event.setApprovalStatus(false);
			eventDao.save(event);
			return true;

		}

		catch (Exception e) {
			return false;
		}
	}

}
