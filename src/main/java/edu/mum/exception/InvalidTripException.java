package edu.mum.exception;

public class InvalidTripException extends RuntimeException {
	private static final long serialVersionUID = -5192041563033358491L;
	private String tripId;

	public InvalidTripException(String tripId) {
		this.tripId = tripId;
	}

	public String getTripId() {
		return tripId;
	}
}
