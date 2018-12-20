package edu.mum.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import edu.mum.validator.Persistence;

@Entity
@Table(name = "booking")
public class Booking implements Serializable {
	
	private static final long serialVersionUID = -1703806514696828526L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@NotNull(message = "{msg.error.required}", groups = {Persistence.class})
	@Column(name = "confirmationCode")
	private String confirmationCode;
	
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "bookingDate")
	private Date bookingDate;

	@Valid
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "trip_id")
	@JsonBackReference
    private Trip trip;
	
	@Valid
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "passenger_id")
	@JsonManagedReference
    private Passenger passenger;
    
	public Booking() {
		this.passenger = new Passenger();
		this.trip = new Trip();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConfirmationCode() {
		return confirmationCode;
	}

	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", confirmationCode=" + confirmationCode + ", bookingDate=" + bookingDate
				+ ", trip=" + trip + ", passenger=" + passenger + "]";
	}
}
