package com.jsp.job_portal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jsp.job_portal.dto.PortalUser;
import com.jsp.job_portal.repository.PortalUserRepository;

import jakarta.validation.Valid;


@Repository
public class PortalUserDao
{
	
	@Autowired
	PortalUserRepository userRepository;
	
	
	public boolean existsByEmail(String email)
	{
		return userRepository.existsByEmail(email);
		
	}
	
	public boolean existsByMobile(long mobile)
	{
		return userRepository.existsByMobile(mobile);
		
	}


	public void saveUser(PortalUser portalUser) {
		userRepository.save(portalUser);
		
	}


	public PortalUser findUserById(int id) {
		
		return userRepository.findById(id).orElse(null);
	}


	

}
