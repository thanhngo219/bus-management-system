package edu.mum.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import edu.mum.domain.Operator;
import edu.mum.service.OperatorService;

@Component
public class OperatorFormatter implements Formatter<Operator> {

	@Autowired
	private OperatorService service;

	@Override
	public String print(Operator c, Locale locale) {
		return c.getOperatorName();
	}

	@Override
	public Operator parse(String text, Locale locale) throws ParseException {
		System.out.println("Parsing Operator from: " + text);
		Operator airline = service.findOne(Long.parseLong(text));
		return airline;
	}

}
