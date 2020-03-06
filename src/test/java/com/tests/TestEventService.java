package com.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.bean.Event;
import com.bean.User;
import com.dao.EventDao;
import com.dao.UserDao;
import com.service.EventService;

class TestEventService {

	EventDao eventDao;
	UserDao userDao;
	Event event;
	User user;
	EventService service;

	@BeforeEach
	public void setUp() {
		
		eventDao = Mockito.mock(EventDao.class);
		userDao = Mockito.mock(UserDao.class);
		
		event = new Event();
		user = new User();
		
		user.setId(5);
		event.setId(2);
		
		service = new EventService();
		service.setEventDao(eventDao);
		service.setUserDao(userDao);
		
	}
	
	@Test
	public void testSubscribeEventForNullParameters() {
		
		assertFalse(service.subscribeEvent(null, null));
		assertFalse(service.subscribeEvent(2, null));
		assertFalse(service.subscribeEvent(null, 2));
		
		assertFalse(service.subscribeEvent(6, 8));
		
	}
	
	@Test
	public void testSubscribeEventForValidParameters() {
		
		Mockito.when(userDao.findById(3)).thenReturn(Optional.of(user));
		
		Mockito.when(eventDao.findById(1)).thenReturn(Optional.of(event));
		
		boolean result = service.subscribeEvent(1, 3);
		
		assertTrue(result);
		
	}

	@Test
	public void testUnsubscribeEventForNullParameters() {
		
		assertFalse(service.unsubscribeEvent(null, null));
		assertFalse(service.unsubscribeEvent(2, null));
		assertFalse(service.unsubscribeEvent(null, 2));
		
		assertFalse(service.unsubscribeEvent(6, 8));
		
	}
	
	@Test
	public void testUnsubscribeEventForValidParameters() {
		
		Mockito.when(userDao.findById(3)).thenReturn(Optional.of(user));
		
		Mockito.when(eventDao.findById(1)).thenReturn(Optional.of(event));
		
		boolean result = service.unsubscribeEvent(1, 3);
		
		assertTrue(result);
		
	}

}
