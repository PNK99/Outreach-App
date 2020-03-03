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
	
	
	public void joinVolunteer(int id) {
		Optional<User> userOp=userDao.findById(1);
		Optional<Event> eventOp=eventDao.findById(id);
		
		User user=userOp.get();
		Event event =eventOp.get();
		
		user.getEvents().add(event);
		userDao.save(user);
		
	}
	
	public Set<Event> getYourEvents(){
		Optional<User> user = userDao.findById(1);
		Set<Event> listOfEvents= user.get().getEvents();
		
		return listOfEvents;
		
	}
}
