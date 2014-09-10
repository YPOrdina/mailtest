package gwtblaat.server;

import gwtblaat.client.MailService;
import gwtblaat.shared.FieldVerifier;

import java.util.Arrays;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class MailServiceImpl extends RemoteServiceServlet implements MailService {

	public String mailServer(String message, String sender, String recipient) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(message)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException("Name must be at least 4 characters long");
		}


		// Escape data from the client to avoid cross-site script vulnerabilities.
		message = escapeHtml(message);

		//let's do it
		MailClient mailClient = new MailClient();
		List<InternetAddress> listTo;
		try {
			listTo = Arrays.asList(
					new InternetAddress(recipient)
					);
			InternetAddress from = new InternetAddress(sender);
			mailClient.sendMail(listTo, from, "Fucking Awesome MailApp!", message);
			return "Hello, " + message + " verstuurd aan "+recipient + " door "+ sender +"!";
			
		} catch (AddressException e) {
			return "anders vul je even een valide mailadres in..."; 
		} catch (MessagingException e) {
			return e.getMessage();
		}
				
		
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}
}
