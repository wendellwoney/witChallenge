package com.wendellwoney.rest.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wendellwoney.queue.Dto.ResultDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel {
    private boolean hasError;
    private String message;
    private String operationId;

    private Double result;

    public ResponseModel(boolean hasError, String message) {
        this.hasError = hasError;
        this.message = message;
    }

    public ResponseModel(boolean hasError, String operationId, String message) {
        this.hasError = hasError;
        this.message = message;
        this.operationId = operationId;
    }

    public ResponseModel(boolean hasError, String operationId, Double result) {
        this.hasError = hasError;
        this.result = result;
        this.operationId = operationId;
    }
}
