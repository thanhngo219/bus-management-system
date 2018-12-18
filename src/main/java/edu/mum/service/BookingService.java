package edu.mum.service;

import edu.mum.domain.Booking;

public interface BookingService {
	public Booking saveBooking(Booking booking);
	public Booking findBookingByCC(String cCode);
	
}
