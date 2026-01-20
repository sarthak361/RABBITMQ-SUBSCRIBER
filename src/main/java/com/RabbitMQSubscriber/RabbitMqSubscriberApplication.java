package com.RabbitMQSubscriber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMqSubscriberApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqSubscriberApplication.class, args);
		System.out.print("RabbitMQ Subscriber");
	}

}
