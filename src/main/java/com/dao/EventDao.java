package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bean.Event;

public interface EventDao extends JpaRepository<Event, Integer> {

	@Query("select event from Event event where event.approvalStatus=true")
	public List<Event> getApprovedEvents();

}
