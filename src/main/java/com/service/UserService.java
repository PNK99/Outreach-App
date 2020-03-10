
package com.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.User;
import com.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public void registerUser(User u) {

		System.out.println(u.getUserRole());
		byte[] encodedBytes = Base64.getEncoder().encode(u.getPassword().getBytes());
		u.setPassword(new String(encodedBytes));

		//List<User> userList = userDao.findByUserId(u.getUserId());

		userDao.save(u);

	}

	public User loginUser(Integer userId, String password) {

		byte[] encodedBytes = Base64.getEncoder().encode(password.getBytes());
		User user = userDao.validateUser(userId, new String(encodedBytes));
		
		return user;
		
	}
	
	public boolean userIdExists(Integer userId) {
		
		List<User> userList = userDao.userIdExists(userId);
		
		return !userList.isEmpty();

	}

}
