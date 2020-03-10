package com.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bean.Event;
import com.bean.User;

public interface EventDao extends JpaRepository<Event, Integer> {
	
}
