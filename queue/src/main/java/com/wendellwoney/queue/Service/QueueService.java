package com.wendellwoney.queue.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class QueueService implements IQueueService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sender(String queue, Object message, String uuid) {

        this.rabbitTemplate.convertAndSend(queue, message, m -> {
            m.getMessageProperties().setHeader("uuid", uuid);
            return m;
        });
    }
}
