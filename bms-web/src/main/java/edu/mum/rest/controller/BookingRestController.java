package edu.mum.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.domain.Booking;
import edu.mum.service.BookingService;

@RestController
@RequestMapping({ "/rest/bookings" })
public class BookingRestController {

	@Autowired
	private BookingService bookingService;

	@RequestMapping("/{code}")
	public Booking finBooking(@PathVariable("code") String code) {
		return bookingService.findBookingByCC(code);
	}
}
