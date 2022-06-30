package com.wendellwoney.queue.Dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResultDto implements Serializable {

    private Double result;

    public ResultDto(Double result) {
        this.result = result;
    }

}
