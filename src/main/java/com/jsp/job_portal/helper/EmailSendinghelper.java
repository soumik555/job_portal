package com.jsp.job_portal.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.jsp.job_portal.dto.PortalUser;


import jakarta.mail.internet.MimeMessage;

@ Service
public class EmailSendinghelper {
	
	@Autowired JavaMailSender mailSender;
	
	@Autowired
	TemplateEngine templateEngine;
	
	
	public void sendOtp(PortalUser portalUser) 
	{
		
		MimeMessage messsge =mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(messsge);
		
		try
		{
			
		
		helper.setFrom("soumiksardar535@gmail.com","Job-Portal");//job portal is name
		helper.setTo(portalUser.getEmail());
		helper.setSubject("Otp Verification Process");
		
		Context context=new Context();
		context.setVariable("name", portalUser.getName());
		context.setVariable("otp", portalUser.getOtp());
		
		String text=templateEngine.process("MyEmail.html", context);
		
		helper.setText(text, true);
		
		mailSender.send(messsge);
		
	}
		catch(Exception e)
		{
			System.out.println("Error-Not able to send Email");
			
		}
	
	
	

}
	
}
