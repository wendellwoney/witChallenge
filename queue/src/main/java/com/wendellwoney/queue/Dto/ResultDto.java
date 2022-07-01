package com.wendellwoney.queue.Dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResultDto implements Serializable {

    private Boolean hasError;
    private Double result;

    public ResultDto(Double result, Boolean hasError) {
        this.result = result;
        this.hasError = hasError;
    }
}
