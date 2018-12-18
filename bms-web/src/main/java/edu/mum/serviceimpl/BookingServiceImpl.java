package edu.mum.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.BookingDao;
import edu.mum.domain.Booking;
import edu.mum.service.BookingService;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingDao bookingDao;
	
//	@Autowired
//	BookingRepository bookingRepository;


	@Override
	public Booking saveBooking(Booking booking) {
		return bookingDao.update(booking);
		
	}

	@Override
	public Booking findBookingByCC(String cCode) {
		return bookingDao.findBookingByConfirmationCode(cCode);
	}

}
