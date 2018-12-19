package edu.mum.batch;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import edu.mum.domain.Trip;
import edu.mum.rest.service.TripService;

@Component
public class TripBatch {
	@Autowired
	TripService tripService;

	@Scheduled(fixedDelay = 30000)
	public void demoServiceMethod() {
		List<Trip> trips = tripService.list();
		System.out.println("> Received " + trips.size() + " Trips from Rest");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		Date yesterday = cal.getTime();
		System.out.println(">   Deleting Trips before " + yesterday);
		for (Trip trip : trips) {
			if (trip.getDepartureDate().before(yesterday)) {
				System.out.println(">     Delete Trip " + trip);
				tripService.delete(trip.getId());
			}
		}
	}
}
