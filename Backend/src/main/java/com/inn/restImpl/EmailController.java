package com.inn.restImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inn.model.EmailRequest;
import com.inn.serviceImpl.EmailService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@CrossOrigin("*")
@RestController
@SwaggerDefinition(tags = {
	    @Tag(name = "EmailController", description = "Rest APIs related to email") })
public class EmailController {

	@Autowired
	private EmailService  emailservice;
	
	//api to sent email
	@RequestMapping(value="/sendEmail",method=RequestMethod.POST)
	@ApiOperation(value="sends email",notes="This Api sends email")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request)
	{
		boolean result= this.emailservice.sendEmail(request.getSubject(),request.getMessage(),request.getTo(),request.getAttachment());
		if(result)
		return 	ResponseEntity.ok("Email is  Sent Successfully.");
		else
			return 	ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent.");
	}
}
