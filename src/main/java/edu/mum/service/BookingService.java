package edu.mum.service;

import edu.mum.domain.Booking;

/**
 * 
 * @author Quang Hiep Nguyen
 *
 */
public interface BookingService {
	public Booking saveBooking(Booking booking);
	public Booking findBookingByCC(String cCode);
	
}
