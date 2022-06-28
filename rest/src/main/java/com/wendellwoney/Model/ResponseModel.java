package com.wendellwoney.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel {
    private boolean hasError;
    private String message;
    private String operationId;

    public ResponseModel(boolean hasError, String message) {
        this.hasError = hasError;
        this.message = message;
    }

    public ResponseModel(boolean hasError, String operationId, String message) {
        this.hasError = hasError;
        this.message = message;
        this.operationId = operationId;
    }
}
