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
	private String operatorName;
	@OneToMany(mappedBy = "operator")
	@OrderBy("departureDate, departureTime")
	private List<Trip> trips;

	/* Constructors */
	public Operator() {
	}

	public Operator(String operatorName) {
		this.operatorName = operatorName;
	}

	/* Getters & Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
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
			trip.setOperator(this);
			success = true;
		}
		return success;
	}

	public boolean removeTrip(Trip trip) {
		boolean success = false;
		if (trips.remove(trip)) {
			trip.setOperator(null);
			success = true;
		}
		return success;
	}
}
