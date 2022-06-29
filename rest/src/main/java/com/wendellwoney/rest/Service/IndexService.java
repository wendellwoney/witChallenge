package com.wendellwoney.rest.Service;

import com.wendellwoney.rest.Dto.OperationDto;
import com.wendellwoney.rest.Enum.OperationEnum;
import com.wendellwoney.rest.Model.ResponseModel;
import com.wendellwoney.rest.Tool;
import com.wendellwoney.queue.Service.QueueService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IndexService implements IIndexService{

    private final QueueService queueService;

    @Autowired
    public IndexService(QueueService queueService) {
        this.queueService = queueService;
    }

    @Value("${rabbitmq.queue.operation}")
    private String queueOperation;

    @Override
    public ResponseModel sum(Double valueOne, Double valueTwo) throws OperationException {
        try {
            String uuid = Tool.uuid();
            this.queueService.sender(this.queueOperation, new OperationDto(uuid, OperationEnum.SUM, valueOne, valueTwo));
            return new ResponseModel(false, uuid, "Request sum sent");
        } catch (Exception e) {
            throw new OperationException("Erro to send operation sun!");
        }
    }

    @Override
    public ResponseModel minus(Double valueOne, Double valueTwo) throws OperationException {
        try {
            String uuid = Tool.uuid();
            this.queueService.sender(this.queueOperation, new OperationDto(uuid, OperationEnum.MINUS, valueOne, valueTwo));
            return new ResponseModel(false, uuid, "Request minus sent");
        } catch (Exception e) {
            throw new OperationException("Erro to send operation minus!");
        }
    }

    @Override
    public ResponseModel mutiply(Double valueOne, Double valueTwo) throws OperationException {
        try {
            String uuid = Tool.uuid();
            this.queueService.sender(this.queueOperation, new OperationDto(uuid, OperationEnum.MUTIPLY, valueOne, valueTwo));
            return new ResponseModel(false, uuid, "Request mutiply sent");
        } catch (Exception e) {
            throw new OperationException("Erro to send operation mutiply!");
        }
    }

    @Override
    public ResponseModel division(Double valueOne, Double valueTwo) throws OperationException {
        try {
            String uuid = Tool.uuid();
            this.queueService.sender(this.queueOperation, new OperationDto(uuid, OperationEnum.DIVISION, valueOne, valueTwo));
            return new ResponseModel(false, uuid, "Request division sent");
        } catch (Exception e) {
            throw new OperationException("Erro to send operation division!");
        }
    }
}
