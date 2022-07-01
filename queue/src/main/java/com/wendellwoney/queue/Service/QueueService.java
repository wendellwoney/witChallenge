package com.wendellwoney.queue.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class QueueService implements IQueueService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sender(String queue, Object message, String uuid) {

        try {
            logger.info("Sendin rabbitmq: Exchange " +  rabbitTemplate.getConnectionFactory().getPort() + " Queue " + queue + " Uuid " + uuid);
            this.rabbitTemplate.convertAndSend(queue, message, m -> {
                m.getMessageProperties().setHeader("uuid", uuid);
                return m;
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
