package com.wendellwoney;

import java.util.UUID;

public class Tool {
    public static String uuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
