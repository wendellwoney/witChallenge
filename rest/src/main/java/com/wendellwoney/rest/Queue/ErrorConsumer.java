package com.wendellwoney.rest.Queue;

import com.wendellwoney.queue.Dto.ErrorDto;
import com.wendellwoney.queue.Dto.ResultDto;
import com.wendellwoney.queue.Exception.OperationException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class ErrorConsumer {
    @RabbitListener(queues = "${rabbitmq.queue.error}")
    private void consumer(ErrorDto errorDto, @Header("uuid") String uuid) throws OperationException {
        try{
            Error.setError(uuid, errorDto);
        } catch (Exception e) {
            throw new OperationException(e.getMessage());
        }
    }
}
