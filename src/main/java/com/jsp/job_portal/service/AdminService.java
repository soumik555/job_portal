package com.jsp.job_portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.jsp.job_portal.dao.PortalUserDao;
import com.jsp.job_portal.dto.PortalUser;
import com.jsp.job_portal.helper.AES;

@Service
public class AdminService {
	@Autowired
	PortalUserDao userDao;

	public String createAdmin(String email, String password, ModelMap map) {
		if (userDao.existsByEmail(email)) {
			map.put("fail", "email already exists");
			return "home.html";
		} else {
			PortalUser portalUser = new PortalUser();
			portalUser.setEmail(email);
			portalUser.setPassword(AES.encrypt(password, "123"));
			portalUser.setRole("admin");
			portalUser.setVerified(true);
			userDao.saveUser(portalUser);
			map.put("sucess", "admin signup success");
			return "login.html";
		}
	}
}
