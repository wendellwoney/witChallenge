package com.wendellwoney.queue.Exception;

public class OperationException extends Exception{
    public OperationException(String errorMessage) {
        super(errorMessage);
        printStackTrace();
    }
}
