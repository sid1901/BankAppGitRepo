package com.csc.BankingApp.Services;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
//File Name SendEmail.java
//public class SendEmail {

   // Recipient's email ID needs to be mentioned.


public class CommonServices {

	//code to generate 10digit random acc no.
	public String randomNumGen(){
		int len=10;
		String ALPHA_NUM = "0123456789";
		String result =null;

		StringBuffer sb = new StringBuffer(len);
			for (int i = 0; i < len; i++) {
				int ndx = (int) (Math.random() * ALPHA_NUM.length());
				sb.append(ALPHA_NUM.charAt(ndx));
			}
			result= sb.toString();
		return result;
	}
	
	public void sendMail()
	{
			System.out.println("Lets Send the Mail :) ");
			String to = "sid.sethi1901@gmail.com";

		   // Sender's email ID needs to be mentioned
		   String from = "sid.x.sethi@gmail.com";

		   // Assuming you are sending email from localhost
		   String host = "localhost";

		   // Get system properties
		   Properties properties = System.getProperties();

		   // Setup mail server
		   properties.setProperty("mail.smtp.host", host);

		   // Get the default Session object.
		   Session session = Session.getDefaultInstance(properties);

		   try {
		      // Create a default MimeMessage object.
		      MimeMessage message = new MimeMessage(session);

		      // Set From: header field of the header.
		      message.setFrom(new InternetAddress(from));

		      // Set To: header field of the header.
		      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		      // Set Subject: header field
		      message.setSubject("This is the Subject Line!");

		      // Now set the actual message
		      message.setText("This is actual message");

		      // Send message
		      Transport.send(message);
		      System.out.println("Sent message successfully....");
		   }catch (MessagingException mex) {
		      mex.printStackTrace();
		   }
		}
}
	
	
	
