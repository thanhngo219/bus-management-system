package edu.mum.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Station implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty(message = "{msg.error.string.empty}")
	private String code;
	@NotEmpty(message = "{msg.error.string.empty}")
	private String name;
	@NotEmpty(message = "{msg.error.string.empty}")
	private String city;
	@NotEmpty(message = "{msg.error.string.empty}")
	private String country;
	@OneToMany(mappedBy = "destination")
	@OrderBy("arrivalDate, arrivalTime")
	private List<Trip> arrivals;
	@OneToMany(mappedBy = "origin")
	@OrderBy("departureDate, departureTime")
	private List<Trip> departures;

	/* Constructors */
	public Station() {
	}

	public Station(String code, String name, String city, String country) {
		this.code = code;
		this.name = name;
		this.city = city;
		this.country = country;
	}

	/* Getters & Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Trip> getArrivals() {
		return arrivals;
	}

	public void setArrivals(List<Trip> arrivals) {
		this.arrivals = arrivals;
	}

	public List<Trip> getDepartures() {
		return departures;
	}

	public void setDepartures(List<Trip> departures) {
		this.departures = departures;
	}

	/* Collection methods */
	public boolean addArrival(Trip trip) {
		boolean success = false;
		if (arrivals.add(trip)) {
			trip.setDestination(this);
			success = true;
		}
		return success;
	}

	public boolean removeArrival(Trip trip) {
		boolean success = false;
		if (arrivals.remove(trip)) {
			trip.setDestination(null);
			success = true;
		}
		return success;
	}

	public boolean addDeparture(Trip trip) {
		boolean success = false;
		if (departures.add(trip)) {
			trip.setOrigin(this);
			success = true;
		}
		return success;
	}

	public boolean removeDeparture(Trip trip) {
		boolean success = false;
		if (departures.remove(trip)) {
			trip.setOrigin(null);
			success = true;
		}
		return success;
	}
	
	public String getAirportDetail() {
		return code + " - " + name + " - " + city;
	}
}
