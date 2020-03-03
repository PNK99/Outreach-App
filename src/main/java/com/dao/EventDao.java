package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bean.Event;

public interface EventDao extends JpaRepository<Event, String> {
	
}
