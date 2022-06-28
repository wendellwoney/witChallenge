package com.wendellwoney.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class ResponseModel {
    private boolean hasError;
    private String message;

    public ResponseModel(boolean hasError, String message) {
        this.hasError = hasError;
        this.message = message;
    }

}
