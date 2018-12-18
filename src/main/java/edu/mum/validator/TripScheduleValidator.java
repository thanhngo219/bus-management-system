package edu.mum.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import edu.mum.domain.Trip;

@Component
public class TripScheduleValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Trip flight = (Trip) target;
		Date departure = parseDateTime(flight.getDepartureDate(), flight.getDepartureTime(), "MM/dd/yyyy", "HH:mm");
		Date arrival = parseDateTime(flight.getArrivalDate(), flight.getArrivalTime(), "MM/dd/yyyy", "HH:mm");

		if (departure == null) {
			errors.rejectValue("departureDate", "msg.error.format.datetime");
		}
		
		if (arrival == null) {
			errors.rejectValue("arrivalDate", "msg.error.format.datetime");
		}
		
		if (departure != null && arrival != null && !departure.before(arrival)) {
			errors.rejectValue("arrivalDate", "msg.error.flight.departure.arrival.contraint");
		}

		if (flight.getOperator() == null || flight.getOperator().getId() <= 0) {
			errors.rejectValue("airline", "msg.error.airline.not.selected");
		}

		if (flight.getBus() == null || flight.getBus().getId() <= 0) {
			errors.rejectValue("airplane", "msg.error.airplane.not.selected");
		}

		if (flight.getOrigin() == null || flight.getOrigin().getId() <= 0) {
			errors.rejectValue("origin", "msg.error.origin.not.selected");
		}

		if (flight.getDestination() == null || flight.getDestination().getId() <= 0) {
			errors.rejectValue("destination", "msg.error.destination.not.selected");
		}
	}

	private Date parseDateTime(Date date, Date time, String dformat, String tformat) {
		if (date != null && time != null) {
			DateFormat df = new SimpleDateFormat(dformat);
			DateFormat tf = new SimpleDateFormat(tformat);
			DateFormat sdf = new SimpleDateFormat(dformat + " " + tformat);
			try {
				return sdf.parse(df.format(date) + " " + tf.format(time));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

}
