package com.wendellwoney.queue.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
public class QueueService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public QueueService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sender(String queue, Object message) {
        this.rabbitTemplate.convertAndSend(queue, message);
    }
}
