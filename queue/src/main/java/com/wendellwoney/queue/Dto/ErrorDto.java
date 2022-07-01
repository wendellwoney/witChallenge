package com.wendellwoney.queue.Dto;

import com.wendellwoney.queue.Enum.OperationEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ErrorDto implements Serializable {

    private String operationId;
    private String operation;
    private Double valueA;
    private Double valueB;

    public ErrorDto(String uuid, String operation, Double valueA, Double valueB) {
        this.operationId = uuid;
        this.operation = operation;
        this.valueA = valueA;
        this.valueB = valueB;
    }
}
