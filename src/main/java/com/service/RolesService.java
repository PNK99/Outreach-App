package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Roles;
import com.dao.RolesDao;

@Service
public class RolesService {

	@Autowired
	private RolesDao rolesDao;

	public Map<Integer, String> getRolesList() {

		Map<Integer, String> rolesMap = new HashMap<>();

		List<Roles> rolesList = rolesDao.findAll();

		for (Roles roles : rolesList) {

			rolesMap.put(roles.getRoleId(), roles.getRoleName());

		}

		return rolesMap;

	}

}
