package com.wendellwoney.calculator.Service;

import com.wendellwoney.calculator.Tool;
import com.wendellwoney.queue.Dto.OperationDto;
import com.wendellwoney.queue.Dto.ResultDto;
import com.wendellwoney.queue.Exception.OperationException;
import com.wendellwoney.queue.Service.IQueueService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.math.RoundingMode;

@Service
@Getter
public class OperationService {

    @Autowired
    private IQueueService queueService;

    @Value("${rabbitmq.queue.result}")
    private String queueResult;

    @Value("${arbitrary.precission}")
    private Integer precision;

    @Value("${arbitrary.scale}")
    private Integer scale;

    private RoundingMode getPrecision() {
        return RoundingMode.valueOf(this.precision);
    }

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

    private Double sum (Double valueA, Double valueB) throws OperationException {
        return new Tool().numberPrecision((valueA + valueB), this.getPrecision(), this.getScale());
    }

    private Double minus (Double valueA, Double valueB) throws OperationException {
        return new Tool().numberPrecision((valueA - valueB), this.getPrecision(), this.getScale());
    }

    private Double multiply (Double valueA, Double valueB) throws OperationException {
        return new Tool().numberPrecision((valueA * valueB), this.getPrecision(), this.getScale());
    }

    private Double division (Double valueA, Double valueB) throws OperationException {
        return new Tool().numberPrecision((valueA / valueB), this.getPrecision(), this.getScale());
    }

}