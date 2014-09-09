package mavenmailtest;

//File Name SendEmail.java

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail
{
public static void main(String [] args)
{    
   // Recipient's email ID needs to be mentioned.
   String to = "frank.verbruggen@ordina.nl";

   // Sender's email ID needs to be mentioned
   String from = "nielsmaneschijn@ziggo.nl";

   // Assuming you are sending email from localhost
   String host = "smtp.ziggo.nl";

   // Get system properties
   Properties properties = System.getProperties();

   // Setup mail server
   properties.setProperty("mail.smtp.host", host);

   // Get the default Session object.
   Session session = Session.getDefaultInstance(properties);

   try{
      // Create a default MimeMessage object.
      MimeMessage message = new MimeMessage(session);

      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));

      // Set To: header field of the header.
      message.addRecipient(Message.RecipientType.TO,
                               new InternetAddress(to));

      // Set Subject: header field
      message.setSubject("Fucking Awesome!");

      // Now set the actual message
      message.setText("This mail courtesy of javax.mail, Maven, search.maven.org, smtp.ziggo.nl & VPN! :)");

      // Send message
      Transport.send(message);
      System.out.println("Sent message successfully....");
   }catch (MessagingException mex) {
      mex.printStackTrace();
   }
}
}