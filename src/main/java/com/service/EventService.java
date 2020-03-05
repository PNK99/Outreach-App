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

	public void subscribeEvent(int eventId, int userId) {
		Optional<User> userOp = userDao.findById(userId);
		Optional<Event> eventOp = eventDao.findById(eventId);

		User user = userOp.get();
		Event event = eventOp.get();

		event.getVolunteers().add(user);

		eventDao.save(event);

	}

	public Set<Event> getYourEvents(int userId) {
		Optional<User> user = userDao.findById(userId);
		Set<Event> listOfEvents = user.get().getEvents();

		return listOfEvents;

	}

	public void unsubscribeEvent(int eventId, int userId) {
		Optional<User> userOp = userDao.findById(userId);
		Optional<Event> eventOp = eventDao.findById(eventId);

		User user = userOp.get();
		Event event = eventOp.get();

		event.getVolunteers().remove(user);
		eventDao.save(event);

	}

	public List<User> getAllVolunteers() {
		List<User> users = userDao.findAllVolunteers();
		return users;
	}
	
	public void inviteVolunteer(int eventId, Integer ids[]) {
		Event event = eventDao.findById(eventId).get();

		for(Integer id: ids) {
			User user =  userDao.findById(id).get();
			event.getInvitedPeople().add(user);
		}
		eventDao.save(event);
	}
	
	public Set<Event> getInvitedEvents(int userId){
		User user = userDao.findById(userId).get();
		Set<Event> events = user.getInvitedEvents();
		return events;
	}

}
