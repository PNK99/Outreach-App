package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bean.Roles;
import com.dao.RolesDao;

@Service
public class RolesService {

	private RolesDao rolesDao;
	
	@ModelAttribute("rolesList")
	public Map<Integer, String> getRolesList() {
		
		Map<Integer, String> rolesMap = new HashMap<>();
		
		List<Roles> rolesList = rolesDao.findAll();
		
		for (Roles roles : rolesList) {
			
			rolesMap.put(roles.getRoleId(), roles.getRoleName());
			
		}
		
		return rolesMap;
		
	}
	
}
