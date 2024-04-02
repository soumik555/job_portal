package com.jsp.job_portal.service;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.jsp.job_portal.dao.PortalUserDao;
import com.jsp.job_portal.dto.PortalUser;
import com.jsp.job_portal.helper.EmailSendinghelper;




@Service


public class PortalUserService {
	
	@Autowired
	PortalUserDao userDao;
	
	@Autowired
	EmailSendinghelper emailhelper;
	
	
	public String signup(PortalUser portalUser, BindingResult result, ModelMap map)  
	{
		if(portalUser.getDob()==null)
		{
			result.rejectValue("dob", "error.dob","*Select a Date");
			System.out.println("Age is not selected");
			
		}
		if(LocalDate.now().getYear()-portalUser.getDob().getYear()<18)
		  {
			result.rejectValue("dob", "error.dob", "*Age should be greater than 18");
			System.out.println("Error-Age is not Greater thena 18");
		  }
		  
		  if(!portalUser.getPassword().equals(portalUser.getConfirm_password()))
		  {	  result.rejectValue("confirm_password", "error.confirm_password", "*Password and Confirm Password should be Matching");
		  System.out.println("Error-Password is not Matching");
		  
		  
		  if(userDao.existsByEmail(portalUser.getEmail()))
		  {
			  result.rejectValue("email", "error.email", "*Email should be unique");
			  System.out.println("Error-Email already exists");
			  
		  }
		  
		  if(userDao.existsByMobile(portalUser.getMobile()))
		  {
			  result.rejectValue("mobile", "error.mobile","*Mobile should be unique");
			  
			  System.out.println("Error-Mobile already exists");
		  }
			
		      }
		  if(result.hasErrors())
		  {
			  System.out.println("Error-There is some errors");
			  return "signup.html";
		  }
		  
		  else
		  {  
			  System.out.println("No Errors");
			  int otp=new Random().nextInt(100000,999999);
			  System.out.println("Otp generated " + otp);
			  portalUser.setOtp(otp);
			  userDao.saveUser(portalUser);
			  System.out.println("Data is saved in DB");
			  emailhelper.sendOtp(portalUser);
			  
			  map.put("msg", "Otp send Success");
			  map.put("id", portalUser.getId());
			  return "enter-otp.html";
			  
		  }
		  
		  
	}
	public String submitOtp(int otp, int id, ModelMap map) {
		PortalUser portalUser=userDao.findUserById(id);
		if(otp==portalUser.getOtp())
		{
			portalUser.setVerified(true);
			userDao.saveUser(portalUser);
			map.put("msg", "Account Created Successfully");
			return "login";
			
		}
		else
		{
			map.put("msg", "Incorrect Otp try Again!");
			map.put("id", portalUser.getId());
			return "enter-otp";
		}
	}
	

}
