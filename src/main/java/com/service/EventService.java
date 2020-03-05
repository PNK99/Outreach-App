package com.service;

import java.util.ArrayList;
import java.util.Date;
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
	
	public List<Event> getFutureEvents(){
		
		List<Event> events = eventDao.findAll();
		List<Event> futureEvents=new ArrayList<>();
		
		futureEvents.add(events.get(0));
		Date date=new Date();
		
		for(Event event:events) {
			long diff=event.getDate().getTime()-date.getTime();
			long diffDays =diff/(24*60*60*1000);
			if(diffDays>0 && diffDays<15) {
				futureEvents.add(event);
			}
		}
		
		return futureEvents;
	}

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

	public List<User> getAllVolunteers(Integer userId) {
		List<User> users = userDao.findAllVolunteers(userId);
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
