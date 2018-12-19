
package edu.mum.integration;

import org.springframework.integration.annotation.Transformer;

import edu.mum.domain.Booking;
import edu.mum.domain.PlainBooking;

public class BookingTransformerImpl implements BookingTransformer {

	@Transformer(inputChannel = "fromAmqpBooking", outputChannel = "processBooking")
	public PlainBooking transformItem(Booking booking) {

		PlainBooking newBooking = new PlainBooking();
		newBooking.setConfirmationCode(booking.getConfirmationCode());
		newBooking.setPassengerFirstName(booking.getPassenger().getFirstName());
		newBooking.setPassengerLastName(booking.getPassenger().getLastName());
		newBooking.setPassengerEmail(booking.getPassenger().getEmail());
		newBooking.setTripnr(booking.getTrip().getTripnr());
		newBooking.setOrigin(booking.getTrip().getOrigin().getStationDetail());
		newBooking.setDestination(booking.getTrip().getDestination().getStationDetail());
		newBooking.setDepartureTime(booking.getTrip().getDepartureDate() + " " + booking.getTrip().getDepartureTime());
		newBooking.setArrivalTime(booking.getTrip().getArrivalDate() + " " + booking.getTrip().getArrivalTime());
		newBooking.setOperatorName(booking.getTrip().getOperator().getOperatorName());

		System.out.println("> Transform Booking " + booking.getConfirmationCode() + " to " + newBooking);

		return newBooking;
	}

}
