package com.jsp.job_portal.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
@Component
public class Applicantdetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String skills;
	String Education;
	String Resume;
	
	

}