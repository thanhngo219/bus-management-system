package edu.mum.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
	
	@OneToMany(mappedBy="bus", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy("departureDate, departureTime")
	@JsonBackReference
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

	@Override
	public String toString() {
		return "Bus [id=" + id + ", serialNumber=" + serialNumber + ", model=" + model + ", capacity=" + capacity + "]";
	}
	
}
