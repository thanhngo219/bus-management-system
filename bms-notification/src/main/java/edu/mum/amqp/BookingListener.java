package edu.mum.amqp;

import java.util.Locale;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.domain.Booking;
import edu.mum.emailservice.EmailService;

public class BookingListener {
	@Autowired
	private EmailService emailService;

	public EmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	// Listens on the "directQueue" associated with the "direct" exchange
	public void listen(Booking booking) {
		String name = booking.getConfirmationCode();
		System.out.println("> Received Booking: " + name);
		try {
			emailService.sendBookingReceivedMail(booking, new Locale("en"));
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
