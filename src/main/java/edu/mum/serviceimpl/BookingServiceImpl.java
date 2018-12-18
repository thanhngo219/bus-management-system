package edu.mum.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Booking;
import edu.mum.repository.BookingRepository;
import edu.mum.service.BookingService;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
	@Autowired
	BookingRepository bookingRepository;


	@Override
	public Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);
		
	}

	@Override
	public Booking findBookingByCC(String cCode) {
		return bookingRepository.findBookingByConfirmationCode(cCode);
	}

}
