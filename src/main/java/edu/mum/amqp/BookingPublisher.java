package edu.mum.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.mum.domain.Booking;

public class BookingPublisher {
	private RabbitTemplate rabbitTemplate;

	public void publish(Booking booking) {
		rabbitTemplate.convertAndSend(booking);
	}

	public RabbitTemplate getRabbitTemplate() {
		return rabbitTemplate;
	}

	public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
}
