package com.wendellwoney.rest.Queue;

import com.wendellwoney.queue.Dto.ResultDto;
import com.wendellwoney.queue.Exception.OperationException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class ResultConsumer {
    @RabbitListener(queues = "${rabbitmq.queue.result}")
    private void consumer(ResultDto resultDto, @Header("uuid") String uuid) throws OperationException {
        try{
            Result.setResult(uuid, resultDto);
        } catch (Exception e) {
            throw new OperationException(e.getMessage());
        }
    }
}
