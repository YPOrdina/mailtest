package gwtblaat.server;

import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

public interface MailSender {
	void sendMail(List<InternetAddress> toList, InternetAddress from,
			String subject, String body) throws MessagingException;
}
