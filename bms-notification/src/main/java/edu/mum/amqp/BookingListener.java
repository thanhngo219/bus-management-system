package edu.mum.amqp;

import java.util.Locale;

import javax.mail.MessagingException;

import edu.mum.domain.Booking;
import edu.mum.emailservice.EmailService;

public class BookingListener {
	private EmailService emailService = new EmailService();

	// Listens on the "directQueue" associated with the "direct" exchange
	public void listen(Booking booking) {
		String name = booking.getConfirmationCode();
		System.out.println("---------- DIRECT Consumer for Item: " + name);
		try {
			emailService.sendBookingReceivedMail("nctamus@gmail.com", booking, new Locale("en"));
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
