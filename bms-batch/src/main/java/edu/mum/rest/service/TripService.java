package edu.mum.rest.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.Trip;
import edu.mum.rest.RestHttpHeader;

@Component
public class TripService {

	@Autowired
	RestHttpHeader restHttpHeader;

	String baseUrl = "http://localhost:8080/bms-web/rest/trips/";

	public List<Trip> list() {

		RestTemplate restTemplate = restHttpHeader.getRestTemplate();
		String url = baseUrl;
		System.out.println("Performing REST: " + baseUrl);
		return Arrays.asList(
				restTemplate.exchange(url, HttpMethod.GET, restHttpHeader.getHttpEntity(), Trip[].class).getBody());
		// restHttpHeader.getHttpEntity() - get HTTP headers [Authentication; JSON
		// ACCEPT]
	}

	public Trip delete(Long id) {
		RestTemplate restTemplate = restHttpHeader.getRestTemplate();
		String url = baseUrl + "delete/" + id;
		System.out.println("Performing REST: " + url);
		return (restTemplate.exchange(url, HttpMethod.GET, restHttpHeader.getHttpEntity(), Trip.class).getBody());
		// Returns Trip in Body HTTP Message
	}

}
