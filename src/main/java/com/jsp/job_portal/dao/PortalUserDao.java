package com.jsp.job_portal.dao;

import javax.sound.sampled.Port;

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
	
	
	
	
	public boolean existsByMobile(long mobile)
	{
		return userRepository.existsByMobile(mobile);
		
	}
	
	public boolean existsByEmail(String email)
	{
		return userRepository.existsByEmailAndVerifiedTrue(email);
		
	}


	public void saveUser(PortalUser portalUser) {
		userRepository.save(portalUser);
		
	}


	public PortalUser findUserById(int id) {
		
		return userRepository.findById(id).orElse(null);
	}
	
	public void deleteIfExists(String email)
	{
		PortalUser user=userRepository.findByEmail(email);
		if(user!=null)
		{
			userRepository.delete(user);
			
		}
	}

	public PortalUser findUserByMobile(long mobile) {
		
		return userRepository.findByMobile(mobile);
	}

	public PortalUser findUserEmail(String email) {
		
		return userRepository.findByEmail(email);
	}


	

}
