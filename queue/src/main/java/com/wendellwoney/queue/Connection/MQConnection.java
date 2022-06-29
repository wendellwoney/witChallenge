package com.wendellwoney.queue.Connection;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class MQConnection {

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.queue.operation}")
    private String queueOperation;

    @Value("${rabbitmq.queue.result}")
    private String queueResult;

    private final AmqpAdmin amqpAdmin;

    public MQConnection(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    private Queue queue(String nomeFila) {
        return new Queue(nomeFila, true, false, false);
    }

    private DirectExchange directExchange() {
        return new DirectExchange(this.exchange);
    }

    private Binding binding(Queue queue, DirectExchange directExchange) {
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE, directExchange.getName(), queue.getName(), null);
    }

    @PostConstruct
    private void addQueue() {
        Queue queueOperation = this.queue(this.queueOperation);
        Queue queueResult = this.queue(this.queueResult);

        DirectExchange directExchange = this.directExchange();
        Binding bindingOperation = this.binding(queueOperation,directExchange);
        Binding bindingResult = this.binding(queueResult,directExchange);

        this.amqpAdmin.declareQueue(queueOperation);
        this.amqpAdmin.declareQueue(queueResult);

        this.amqpAdmin.declareExchange(directExchange);

        this.amqpAdmin.declareBinding(bindingOperation);
        this.amqpAdmin.declareBinding(bindingResult);
    }
}
