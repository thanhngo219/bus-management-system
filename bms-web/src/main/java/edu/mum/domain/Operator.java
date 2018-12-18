package edu.mum.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "operator")
public class Operator implements Serializable {

	private static final long serialVersionUID = -7258668323575836429L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@NotEmpty(message = "{msg.error.string.empty}")
	@Column(name = "operatorName")
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
