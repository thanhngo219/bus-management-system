package edu.mum.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import edu.mum.domain.Bus;
import edu.mum.service.BusService;

@Component
public class BusFormatter implements Formatter<Bus> {

	@Autowired
	private BusService busService;

	@Override
	public String print(Bus c, Locale locale) {
		return c.getModel() + " - " + c.getSerialModel();
	}

	@Override
	public Bus parse(String text, Locale locale) throws ParseException {
		System.out.println("Parsing Bus from: " + text);
		Bus bus = busService.findOne(Long.parseLong(text));
		return bus;
	}

}
