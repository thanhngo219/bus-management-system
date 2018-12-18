package edu.mum.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import edu.mum.domain.Station;
import edu.mum.service.StationService;

@Component
public class StationFormatter implements Formatter<Station> {

	@Autowired
	private StationService stationService;

	@Override
	public String print(Station c, Locale locale) {
		return c.getStationCode() + " - " + c.getCity() + " - " + c.getCountry();
	}

	@Override
	public Station parse(String text, Locale locale) throws ParseException {
		System.out.println("Parsing Station from: " + text);
		Station station = stationService.findOne(Long.parseLong(text));
		return station;
	}

}
