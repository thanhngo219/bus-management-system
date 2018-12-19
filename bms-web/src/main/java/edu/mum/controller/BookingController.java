package edu.mum.controller;

import edu.mum.amqp.BookingPublisher;
import edu.mum.domain.Booking;
import edu.mum.domain.Trip;
import edu.mum.service.BookingService;
import edu.mum.service.TripService;

import java.util.Date;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private TripService tripService;

	@Autowired
	private BookingPublisher bookingPulisher;

	@RequestMapping(value = "/mybooking", method = RequestMethod.GET)
	public String getMyBooking() {
		return "booking/myBooking";
	}

	@RequestMapping(value = "/mybooking", method = RequestMethod.POST)
	public String getBooking(@RequestParam("cCode") String cCode, RedirectAttributes rAttributes) {
		Booking booking = bookingService.findBookingByCC(cCode);
		if (booking != null) {
			rAttributes.addFlashAttribute(booking);
			return "redirect:/booking/detail";
		} else {
			rAttributes.addFlashAttribute("cCode", cCode);
			return "redirect:/mybooking";
		}

	}

	@RequestMapping(value = "/booking/detail", method = RequestMethod.GET)
	public String bookingDetail() {
		return "booking/detail";
	}

	@RequestMapping(value = "/booking", method = RequestMethod.GET)
	public String bookingATrip(@RequestParam("tripId") String tripId, Model model) {
		Trip trip = validateTrip(tripId);
		Booking booking = new Booking();
		booking.setTrip(trip);
		model.addAttribute("booking", booking);
		return "jsp/collectPassengerInfo";
	}
	
//	@RequestMapping(value = "/booking", method = RequestMethod.GET, params = {"_eventId_bookingCancelled", "_eventId_cancel"})
//	public String cancelBooking(@ModelAttribute("booking") Booking booking) {
//		return "jsp/bookingCancelled";
//	}

	@RequestMapping(value = "/booking", method = RequestMethod.POST, params = {"_eventId_confirmationTrip"})
	public String gotoConfirmationPage(@Valid @ModelAttribute("booking") Booking booking, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "jsp/collectPassengerInfo";
		}
		return "jsp/bookingConfirmation";
	}
	
	@RequestMapping(value = "/booking", method = RequestMethod.POST, params = {"_eventId_bookingConfirmed"})
	public String bookATrip(@ModelAttribute("booking") Booking booking, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "jsp/bookingConfirmation";
		}
		booking.setConfirmationCode(this.generateCCode(8));
		booking.setBookingDate(new Date());
		Booking booked = bookingService.saveBooking(booking);
		if (booked != null) {
			bookingPulisher.publish(booked);
			return "jsp/thankCustomer";
		}
		return "jsp/bookingConfirmation";
	}

	private Trip validateTrip(String tripId) {
		Trip f = tripService.validateTrip(tripId);
		return f;

	}

	private String generateCCode(int len) {
		// A strong password has Cap_chars, Lower_chars,
		// numeric value and symbols. So we are using all of
		// them to generate our password
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";

		String values = Capital_chars + Small_chars + numbers;

		// Using random method
		Random rndm_method = new Random();

		char[] password = new char[len];

		for (int i = 0; i < len; i++) {
			// Use of charAt() method : to get character value
			// Use of nextInt() as it is scanning the value as int
			password[i] = values.charAt(rndm_method.nextInt(values.length()));

		}
		return password.toString().substring(1);
	}
}
