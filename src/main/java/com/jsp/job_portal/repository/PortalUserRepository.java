package com.jsp.job_portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.job_portal.dto.PortalUser;

import jakarta.persistence.Id;

public interface PortalUserRepository extends JpaRepository<PortalUser, Integer>
{
	boolean existsByEmail(String email);

	boolean existsByMobile(long mobile);
	

}
