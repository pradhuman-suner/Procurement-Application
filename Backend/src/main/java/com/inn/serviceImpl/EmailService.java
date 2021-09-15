package com.inn.serviceImpl;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;
@Service
public class EmailService {

	public boolean sendEmail(String subject,String message,String to,String attachment)
	{
				boolean f=false;
		
				String from="mohitsharma82049@gmail.com";
		
				//variable for gmail host
				String host="smtp.gmail.com";
				
				//get the system properties
				Properties properties= System.getProperties();
			/*	System.out.print(properties); */
				
				//setting important information to properties object
				
				//host set
				properties.put("mail.smtp.host", host);
				properties.put("mail.smtp.port", "465");
				properties.put("mail.smtp.ssl.enable", "true");
				properties.put("mail.smtp.auth", "true");
				
				//to get the session object
				Session session= Session.getInstance(properties,new Authenticator() {

					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						// TODO Auto-generated method stub
							return new PasswordAuthentication(from ,"tnxisylcajaqpffx");
					}
				});
				session.setDebug(true);
				//step 2 the message
				MimeMessage message1= new MimeMessage(session);
				
				//from email
				try {
				message1.setFrom(from);
				//to
				message1.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				
				//add subject to message
				message1.setSubject(subject);
				
				//add text to message
				//message1.setText(message);
				BodyPart messageBodyPart = new MimeBodyPart(); 
				messageBodyPart.setText(message);
				
                // Add Document
				String home = System.getProperty("user.home");
				MimeBodyPart attachmentPart = new MimeBodyPart();
				attachmentPart.attachFile(new File(home+"\\Downloads\\"+attachment+".pdf"));
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(messageBodyPart);
				multipart.addBodyPart(attachmentPart);
				
				message1.setContent(multipart);
				
				//step 3 send message using transport class
				Transport.send(message1);
				System.out.println("sent succesfull");
				f=true;
				
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return f;
	}
}
