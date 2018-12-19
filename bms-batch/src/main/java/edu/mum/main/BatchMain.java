package edu.mum.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BatchMain {

	public static void main(String[] args) {
		final ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"context/applicationContext.xml");
	}
}
