package com.wendellwoney.calculator;

import com.wendellwoney.queue.Exception.OperationException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tool {

    public Double numberPrecision(Double value, RoundingMode precision, Integer scale) throws OperationException {
        try {
            return new BigDecimal(value).setScale(scale, precision).doubleValue();
        } catch (Exception e) {
            throw new OperationException("Error in operation arbitrary precision");
        }

    }

}
