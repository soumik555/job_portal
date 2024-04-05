package com.jsp.job_portal.dto;

import java.time.LocalDate;



import org.springframework.stereotype.Component;

import com.jsp.job_portal.helper.AES;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Component
public class PortalUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min=3,max=15,message="*Enter between 3~15 characters")
	private String name;
	@NotEmpty(message="*This is a required field")
	@Email(message="*Enter Proper Email format")
	private String email;
	@DecimalMin(value="6000000000",message="*Enter proper validation number")
	@DecimalMax(value="9999999999",message="*Enter proper validation number")
	private long mobile;
	@NotNull(message="*This is a require field")
	private LocalDate dob;
	@Size(min=8,max=15,message="*Enter between 8~15 characters")
	private String password;
	@Size(min=8,max=15,message="*Enter between 8~15 characters")
	private String confirm_password;
	@NotNull(message="*This is a required field")
	private String role;
	private int otp;
	private boolean verified;
	
	
	
	
	
	
}
