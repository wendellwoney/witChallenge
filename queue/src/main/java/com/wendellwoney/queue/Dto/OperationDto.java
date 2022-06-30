package com.wendellwoney.queue.Dto;

import com.wendellwoney.queue.Enum.OperationEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OperationDto implements Serializable {
    private OperationEnum operation;
    private Double valueA;
    private Double valueB;

    public OperationDto(OperationEnum operation,Double valueA, Double valueB) {
        this.operation = operation;
        this.valueA = valueA;
        this.valueB = valueB;
    }
}
