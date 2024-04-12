package com.jsp.job_portal.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.jsp.job_portal.dao.PortalUserDao;
import com.jsp.job_portal.dto.ApplicantDetails;
import com.jsp.job_portal.dto.PortalUser;

import jakarta.servlet.http.HttpSession;

@Service
public class ApplicantService {

	@Autowired
	PortalUserDao userDao;

	public String completeProfile(ApplicantDetails details, MultipartFile resume, HttpSession session, ModelMap map) {
		PortalUser portalUser = (PortalUser) session.getAttribute("portalUser");
		if (portalUser == null) {
			map.put("msg", "Invalid Session");
			return "home.html";
		} else {
			
			
			String resumePath = uploadTocloudinary(resume);;// Get from cloudinary
			details.setResumePath(resumePath);
			portalUser.setApplicantDetails(details);
			portalUser.setProfileComplete(true);
			userDao.saveUser(portalUser);
			map.put("msg", "Profile is Completed");
			return "applicant-home.html";
		}
	}
	
	public String uploadTocloudinary(MultipartFile file)
	{
		Cloudinary cloudinary=new Cloudinary(ObjectUtils.asMap(
				
				"cloud_name", "dt4467ngy",
				  "api_key", "587385237932688",
				  "api_secret", "fzF2bUmkIbWAGKh9r52gLYU78Jo"));
				
				
		
		Map resume =null;
		try
		{
			resume=cloudinary.uploader().upload(file.getBytes(),ObjectUtils.emptyMap());
		}
		catch(IOException e)
		{
			e.printStackTrace();
			
		}
		return (String) resume.get("url");
		
	}

}