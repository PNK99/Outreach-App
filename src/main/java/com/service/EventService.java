package com.service;

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
		Optional<User> userOp=userDao.findById(userId);
		Optional<Event> eventOp=eventDao.findById(eventId);
		
		User user=userOp.get();
		Event event =eventOp.get();
		
		
		event.getVolunteers().add(user);
		
		eventDao.save(event);
		
	}
	
	public Set<Event> getYourEvents(int userId){
		Optional<User> user = userDao.findById(userId);
		Set<Event> listOfEvents= user.get().getEvents();
		
		return listOfEvents;
		
	}
	
	
	public void unsubscribeEvent(int eventId,int userId) {
		Optional<User> userOp=userDao.findById(userId);
		Optional<Event> eventOp=eventDao.findById(eventId);
		
		User user=userOp.get();
		Event event =eventOp.get();
		
		
		
		event.getVolunteers().remove(user);
		eventDao.save(event);
		
	}
	
}
