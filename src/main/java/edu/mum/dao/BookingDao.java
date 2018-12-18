package edu.mum.dao;

import edu.mum.domain.Booking;

public interface BookingDao extends GenericDao<Booking> {
	Booking findBookingByConfirmationCode(String cCode);
}
