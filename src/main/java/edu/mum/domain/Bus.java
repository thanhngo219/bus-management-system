package edu.mum.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "bus")
public class Bus implements Serializable {

	private static final long serialVersionUID = -337483805094368303L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@NotEmpty(message = "{msg.error.string.empty}")
	@Column(name = "serialNumber")
	private String serialNumber;
	
	@NotEmpty(message = "{msg.error.string.empty}")
	@Column(name = "model")
	private String model;
	
	@NotNull(message = "{msg.error.required}")
	@Range(min = 0,max = 50, message="{msg.error.range}")
	@Column(name = "capacity")
	private int capacity;
	
	@OneToMany(mappedBy="bus", cascade = CascadeType.ALL)
	@OrderBy("departureDate, departureTime")
	private List<Trip> trips;

	/* Constructors */
	public Bus() {
	}

	public Bus(String serialNumber, String model, int capacity) {
		this.serialNumber = serialNumber;
		this.model = model;
		this.capacity = capacity;
	}

	/* Getters and Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	/* Collection Methods */
	public boolean addTrip(Trip trip) {
		boolean success = false;
		if (trips.add(trip)) { 
			trip.setBus(this);
			success = true;
		}
		return success;
	}
	
	public boolean removeTrip(Trip trip) {
		boolean success = false;
		if (trips.remove(trip)) {
			trip.setBus(null);
			success = true;
		}
		return success;
	}
	
	public String getSerialModel() {
		return serialNumber + " - " + model;
	}
}
