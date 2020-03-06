package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bean.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	@Query("select u from User u where u.userId=:userId and u.password=:password")
	public User validateUser(Integer userId, String password);
	
	@Query("select u from User u where u.userId=:userId")
	public List<User> userIdExists(Integer userId);
	
	@Query("select u from User u where u.userRole=2 and u.id!=:userId")
	public List<User> findAllVolunteers(Integer userId);
	
}
