package edu.mum.jms;

import java.util.Locale;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.domain.PlainBooking;
import edu.mum.emailservice.EmailService;

public class JMSBookingListener implements MessageListener {
	@Autowired
	private EmailService emailService;

	public EmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public void onMessage(Message message) {
		ObjectMessage objectMessage = (ObjectMessage) message;
		PlainBooking booking = null;
		try {
			booking = (PlainBooking) objectMessage.getObject();
			System.out.println("> JMS Received: " + booking);
			emailService.sendBookingReceivedMail(booking, new Locale("en"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
