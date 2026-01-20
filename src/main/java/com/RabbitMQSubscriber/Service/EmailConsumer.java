package com.RabbitMQSubscriber.Service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {

    @RabbitListener(queues = "email-queue")
    public void receiveEmail(String email) {
        System.out.println(" Processing email: " + email);

        
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        System.out.println("Email sent to: " + email);
    }
}
