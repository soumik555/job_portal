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
public class RecruiterDetails  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 private String companyName;
	 private String companyAddress;
	 private long companyMobileNumber;
	 private String licenseNo;
	 private String aboutCompany;
	 private boolean approved;

}
