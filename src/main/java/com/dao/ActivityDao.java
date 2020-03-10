package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bean.Activity;

public interface ActivityDao extends JpaRepository<Activity, Integer> {

}
