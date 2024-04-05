package com.jsp.job_portal.controller;

import java.time.LocalDate;

import java.util.Random;

import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.job_portal.dto.PortalUser;
import com.jsp.job_portal.service.PortalUserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class GeneralController {

	@Autowired
	PortalUser portalUser;
	
	@Autowired
	PortalUserService userService;
	
	
	
	
	@GetMapping("/")
	public String loadHome()
	{
		
		return "home.html";
	}
	
	@GetMapping("/login")
	public String loadLogin()
	
	{
		System.out.println("Control-/, Homepage is displayer");
		return "login.html";
	}
	
	@GetMapping("/signup")
	
		public String loadSignup( ModelMap map)
		
		{
		System.out.println("Control-/login, Login Page is displayer");
		map.put("portalUser", portalUser);//classname should be always in lowercase
			return "signup.html";
		}
		
	
	@PostMapping("/signup")
	
	public String  Signup( @Valid PortalUser portalUser,BindingResult result,ModelMap map)
	{
	  return userService.signup(portalUser, result, map);
	  
   }

	
	
	@PostMapping("/submit-otp")
	public String submitOtp(@RequestParam int otp,@RequestParam int id, ModelMap map)
	{
		return  userService.submitOtp(otp, id, map);
		
	}
	
	@GetMapping("/resend-otp/{id}")
	public String resendOtp(@PathVariable int id, ModelMap map)
	{
		return userService.resendOtp(id,map);
		
	}

	
	@PostMapping ("/login")
	public String login(@RequestParam("email-phone") String emph, @RequestParam String password, ModelMap map, HttpSession session)
	{
		return userService.login(emph,password,map,session);
		
	}
	
	@GetMapping("/logout")
	public String Logout()
	
	{
		System.out.println("Control-/, Logoutpage is displayer");
		return "logout.html";
	}
	
	

	
	
	
}
