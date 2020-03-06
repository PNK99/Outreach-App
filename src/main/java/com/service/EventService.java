package com.service;

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

}
