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

	public List<Event> getFutureEvents(String activity, String place) {

		List<Event> events = eventDao.findAll();

		List<Event> futureEvents = new ArrayList<>();

		Date date = new Date();

		for (Event event : events) {
			long diff = event.getDate().getTime() - date.getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000);
			System.out.println(event.getDate()+""+diffDays);
			if (diffDays >= -1 && diffDays < 15) {
				if (activity == null || event.getActivity().toLowerCase().contains(activity.toLowerCase())) {
					if (place == null || event.getPlace().toLowerCase().contains(place.toLowerCase())) {
						futureEvents.add(event);
					}
				}

			}
		}

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
				}
				else if (user.getFirstName().contains(firstName) && userId == null) {
					filteredUser.add(user);
				}

			}

		}  else
			filteredUser = users;

		return filteredUser;
	}

	public boolean setVolunteerAttendance(Integer eventId, Integer userIds[]) {
		boolean result = true;
		try {
			Event event = eventDao.findById(eventId).get();
			event.getVoluteerPresent().clear();
			if (userIds == null)
				eventDao.save(event);

			for (Integer id : userIds) {

				User user = userDao.findById(id).get();
				event.getVoluteerPresent().add(user);
			}
			eventDao.save(event);

		} catch (Exception e) {
			result = false;
		}

		return result;
	}
	
	
	public boolean isToday(Date eventDate) {
		
		Date date = new Date();

			long diff = eventDate.getTime() - date.getTime();
			long diffHours = diff / ( 60 * 60 * 1000);
			if (diffHours > 0 && diffHours < 12) {
				return true;
			}
			return false;
		
	}

}
