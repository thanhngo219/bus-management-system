package edu.mum.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Operator implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty(message = "{msg.error.string.empty}")
	private String name;
	@OneToMany(mappedBy = "busOperator")
	@OrderBy("departureDate, departureTime")
	private List<Trip> trips;

	/* Constructors */
	public Operator() {
	}

	public Operator(String name) {
		this.name = name;
	}

	/* Getters & Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	/* Collections Methods */
	public boolean addTrip(Trip trip) {
		boolean success = false;
		if (trips.add(trip)) {
			trip.setBusOperator(this);
			success = true;
		}
		return success;
	}

	public boolean removeTrip(Trip trip) {
		boolean success = false;
		if (trips.remove(trip)) {
			trip.setBusOperator(null);
			success = true;
		}
		return success;
	}
}
