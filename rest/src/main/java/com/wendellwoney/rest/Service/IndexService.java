package com.wendellwoney.rest.Service;

import com.wendellwoney.queue.Dto.OperationDto;
import com.wendellwoney.queue.Enum.OperationEnum;
import com.wendellwoney.queue.Exception.OperationException;
import com.wendellwoney.queue.Service.IQueueService;
import com.wendellwoney.rest.Model.ResponseModel;
import com.wendellwoney.rest.Queue.Result;
import com.wendellwoney.rest.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IndexService implements IIndexService {

    @Autowired
    private IQueueService queueService;
    @Value("${rabbitmq.queue.operation}")
    private String queueOperation;

    @Value("${request.timer.wait.response}")
    private long timerWaitResponse;

    @Override
    public ResponseModel sum(Double valueOne, Double valueTwo) throws OperationException {
        try {
            String uuid = Tool.uuid();
            this.queueService.sender(this.queueOperation, new OperationDto(OperationEnum.SUM, valueOne, valueTwo), uuid);

            Thread.sleep(this.timerWaitResponse);
            ResponseModel tryResult = Result.getResult(uuid);
            if (tryResult != null) {
                return tryResult;
            }

            return new ResponseModel(false, uuid, "Request sum sent");
        } catch (Exception e) {
            throw new OperationException("Erro to send operation sun!");
        }
    }

    @Override
    public ResponseModel minus(Double valueOne, Double valueTwo) throws OperationException {
        try {
            String uuid = Tool.uuid();
            this.queueService.sender(this.queueOperation, new OperationDto(OperationEnum.MINUS, valueOne, valueTwo), uuid);

            Thread.sleep(this.timerWaitResponse);
            ResponseModel tryResult = Result.getResult(uuid);
            if (tryResult != null) {
                return tryResult;
            }

            return new ResponseModel(false, uuid, "Request minus sent");
        } catch (Exception e) {
            throw new OperationException("Erro to send operation minus!");
        }
    }

    @Override
    public ResponseModel multiply(Double valueOne, Double valueTwo) throws OperationException {
        try {
            String uuid = Tool.uuid();
            this.queueService.sender(this.queueOperation, new OperationDto(OperationEnum.MULTIPLY, valueOne, valueTwo), uuid);

            Thread.sleep(this.timerWaitResponse);
            ResponseModel tryResult = Result.getResult(uuid);
            if (tryResult != null) {
                return tryResult;
            }

            return new ResponseModel(false, uuid, "Request multiply sent");
        } catch (Exception e) {
            throw new OperationException("Erro to send operation multiply!");
        }
    }

    @Override
    public ResponseModel division(Double valueOne, Double valueTwo) throws OperationException {
        try {
            String uuid = Tool.uuid();
            this.queueService.sender(this.queueOperation, new OperationDto(OperationEnum.DIVISION, valueOne, valueTwo), uuid);

            Thread.sleep(this.timerWaitResponse);
            ResponseModel tryResult = Result.getResult(uuid);
            if (tryResult != null) {
                return tryResult;
            }

            return new ResponseModel(false, uuid, "Request division sent");
        } catch (Exception e) {
            throw new OperationException("Erro to send operation division!");
        }
    }
}
