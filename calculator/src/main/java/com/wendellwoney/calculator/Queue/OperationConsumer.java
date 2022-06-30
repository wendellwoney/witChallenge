package com.wendellwoney.calculator.Queue;

import com.wendellwoney.calculator.Service.OperationService;
import com.wendellwoney.queue.Dto.OperationDto;
import com.wendellwoney.queue.Exception.OperationException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class OperationConsumer {

    @Autowired
    private OperationService service;

    @RabbitListener(queues = "${rabbitmq.queue.operation}")
    private void consumer(OperationDto operationDto, @Header("uuid") String uuid) throws OperationException {
        try{
           try {
               this.service.calculator(operationDto, uuid);
           } catch (Exception e) {
               throw new OperationException(e.getMessage());
           }
        } catch (Exception e) {
            throw new OperationException(e.getMessage());
        }
    }

}
