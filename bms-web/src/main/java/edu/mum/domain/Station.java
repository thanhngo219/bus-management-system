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

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "station")
public class Station implements Serializable {

	private static final long serialVersionUID = 5098421208838150884L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@NotEmpty(message = "{msg.error.string.empty}")
	@Column(name = "stationCode")
	private String stationCode;

	@NotEmpty(message = "{msg.error.string.empty}")
	@Column(name = "stationName")
	private String stationName;

	@NotEmpty(message = "{msg.error.string.empty}")
	@Column(name = "city")
	private String city;

	@NotEmpty(message = "{msg.error.string.empty}")
	@Column(name = "country")
	private String country;

	@OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy("arrivalDate, arrivalTime")
	@JsonBackReference
	private List<Trip> arrivals;

	@OneToMany(mappedBy = "origin", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy("departureDate, departureTime")
	@JsonBackReference
	private List<Trip> departures;

	/* Constructors */
	public Station() {
	}

	public Station(String stationcode, String stationName, String city, String country) {
		this.stationCode = stationcode;
		this.stationName = stationName;
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

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationcode) {
		this.stationCode = stationcode;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
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

	public String getStationDetail() {
		return stationCode + " - " + stationName + " - " + city;
	}

	@Override
	public String toString() {
		return "Station [id=" + id + ", stationCode=" + stationCode + ", stationName=" + stationName + ", city=" + city
				+ ", country=" + country + "]";
	}	
}
