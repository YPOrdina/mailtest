package gwtblaat.server;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class MailClient implements MailSender {

	private Session session;

	public MailClient() {
		// Determine host
		String host = "smtp.ziggo.nl";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		session = Session.getDefaultInstance(properties);
	}

	public void sendMail(List<InternetAddress> recipientList, InternetAddress from, String subject, String body) throws MessagingException {

		// Create a default MimeMessage object.
		MimeMessage message = new MimeMessage(session);

		// Set From: header field of the header.
		message.setFrom(from);

		// Set To: header field of the header.
		for (InternetAddress address : recipientList) {
			message.addRecipient(Message.RecipientType.TO, address);
		}

		// Set Subject: header field
		message.setSubject(subject);

		// Now set the actual message
		message.setText(body);

		// Send message
		Transport.send(message);

		System.out.println("Sent message successfully....");

	}
}