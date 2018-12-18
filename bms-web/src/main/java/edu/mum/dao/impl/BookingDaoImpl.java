package edu.mum.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.BookingDao;
import edu.mum.domain.Booking;

@Repository
public class BookingDaoImpl extends GenericDaoImpl<Booking> implements BookingDao {
	public BookingDaoImpl() {
		super.setDaoType(Booking.class);
	}

	public Booking findBookingByConfirmationCode(String cCode) {
		Query query = entityManager.createQuery("SELECT b FROM Booking b WHERE confirmationCode = :cCode");
		return (Booking) query.setParameter("cCode", cCode).getSingleResult();
	}
}
