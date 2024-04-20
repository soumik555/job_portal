package com.jsp.job_portal.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsp.job_portal.repository.PortalUserRepository;
import com.jsp.job_portal.service.AdminService;


@RequestMapping("/admin")
@Controller
public class AdminController {
	
	
	@Autowired
	AdminService adminService;
	
	
	@Autowired
	PortalUserRepository userRepository;
	
	
	@GetMapping("/create-admin/{email}/{password}")
	public String createAdmin(@PathVariable String email,@PathVariable String password, ModelMap map)
	{
		return adminService.createAdmin(email, password, map);
		
	}
	
	
	@RequestMapping("/approverecruiter")
	public String approve()
	{
		return "ApproveRecruiter.html";
		
	}

}
