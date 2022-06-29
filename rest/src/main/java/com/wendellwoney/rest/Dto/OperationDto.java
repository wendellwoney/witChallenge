package com.wendellwoney.rest.Dto;

import com.wendellwoney.rest.Enum.OperationEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OperationDto implements Serializable {

    public String operationId;
    public OperationEnum operation;
    public Double valueA;
    public Double valueB;


    public OperationDto(String operationId, OperationEnum operation,Double valueA, Double valueB) {
        this.operationId = operationId;
        this.operation = operation;
        this.valueA = valueA;
        this.valueB = valueB;
    }
}
