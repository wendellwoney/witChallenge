package com.wendellwoney.queue.Enum;

public enum  OperationEnum {
    SUM("sum"),
    MINUS("minus"),
    MULTIPLY("multiply"),
    DIVISION("division");

    private final String name;

    private OperationEnum(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
