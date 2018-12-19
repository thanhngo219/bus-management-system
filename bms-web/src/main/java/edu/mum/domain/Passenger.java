package edu.mum.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "passenger")
public class Passenger implements Serializable {
	
	private static final long serialVersionUID = 3614182995918223541L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@NotEmpty(message = "{msg.error.required}")
	@Column(name = "firstName")
	private String firstName;
	
	@NotEmpty(message = "{msg.error.required}")
	@Column(name = "lastName")
	private String lastName;
	
	@NotEmpty(message = "{msg.error.required}")
	@Email
	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL)
	private List<Booking> bookings;
	
	public Passenger() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setPassenger(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", passportNumber="
				+ passportNumber + ", bookings=" + bookings + "]";
	}
	
}
