package com.wendellwoney.calculator.Service;

import com.wendellwoney.queue.Dto.OperationDto;
import com.wendellwoney.queue.Dto.ResultDto;
import com.wendellwoney.queue.Exception.OperationException;
import com.wendellwoney.queue.Service.IQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service
public class OperationService {

    @Autowired
    private IQueueService queueService;

    @Value("${rabbitmq.queue.result}")
    private String queueResult;

    public void calculator (OperationDto operationDto, String uuid) throws OperationException {
        try {
            Double retorno = null;
            Class<?>[] paramTypes = {Double.class, Double.class};
            Method method = this.getClass().getDeclaredMethod(operationDto.getOperation().getName(), paramTypes);
            retorno = (Double) method.invoke(this, operationDto.getValueA(), operationDto.getValueB());

            if (retorno != null) {
                this.queueService.sender(this.queueResult, new ResultDto(retorno), uuid);
            }

        } catch (Exception e) {
            throw new OperationException(e.getMessage());
        }

    }

    private Double sum (Double valueA, Double valueB) {
        return (valueA + valueB);
    }

    private Double minus (Double valueA, Double valueB) {
        return (valueA - valueB);
    }

    private Double multiply (Double valueA, Double valueB) {
        return (valueA * valueB);
    }

    private Double division (Double valueA, Double valueB) {
        return (valueA / valueB);
    }

}