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
	
	
	public void subscribeEvent(int id) {
		Optional<User> userOp=userDao.findById(2);
		Optional<Event> eventOp=eventDao.findById(id);
		
		User user=userOp.get();
		Event event =eventOp.get();
		
		user.getEvents().add(event);
		userDao.save(user);
		
		event.getVolunteers().add(user);
		eventDao.save(event);
		
	}
	
	public Set<Event> getYourEvents(){
		Optional<User> user = userDao.findById(2);
		Set<Event> listOfEvents= user.get().getEvents();
		
		return listOfEvents;
		
	}
	
	
	public void unsubscribeEvent(int id) {
		Optional<User> userOp=userDao.findById(2);
		Optional<Event> eventOp=eventDao.findById(id);
		
		User user=userOp.get();
		Event event =eventOp.get();
		
		user.getEvents().remove(event);
		userDao.save(user);
		
		event.getVolunteers().remove(user);
		eventDao.save(event);
		
	}
	
}
