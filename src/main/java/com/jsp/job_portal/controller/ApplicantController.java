package com.jsp.job_portal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.job_portal.dto.ApplicantDetails;
import com.jsp.job_portal.service.ApplicantService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/applicant")
public class ApplicantController {
	
	@Autowired
	ApplicantService applicantService;

	@GetMapping("/complete-profile")
	public String completeProfile() {
		return "applicant-profile.html";
	}
	@PostMapping("/complete-profile")
	public String completeProfile(ApplicantDetails details,@RequestParam MultipartFile resume,HttpSession session,ModelMap map) {
		return applicantService.completeProfile(details,resume,session,map);
	}
	
}