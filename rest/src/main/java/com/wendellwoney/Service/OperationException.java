package com.wendellwoney.Service;

public class OperationException extends Exception{
    public OperationException(String errorMessage) {
        super(errorMessage);
        printStackTrace();
    }
}
