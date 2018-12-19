package edu.mum;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BMSGatewayMain {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("classpath:META-INF/spring/amqp-common.xml",
				"classpath:META-INF/spring/jms-common.xml", "classpath:META-INF/spring/jms-out.xml",
				"classpath:META-INF/spring/booking-gateway.xml", "classpath:META-INF/spring/applicationContext.xml");

	}
}
