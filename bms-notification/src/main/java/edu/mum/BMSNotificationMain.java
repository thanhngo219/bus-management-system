package edu.mum;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BMSNotificationMain {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("classpath:META-INF/spring/jms-common.xml",
				"classpath:META-INF/spring/jms-in.xml", "classpath:META-INF/spring/applicationContext.xml");

	}
}
