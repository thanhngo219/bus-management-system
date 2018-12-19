
package edu.mum.integration;

import edu.mum.domain.Booking;
import edu.mum.domain.PlainBooking;

public interface BookingTransformer {

	public PlainBooking transformItem(Booking booking);

}
