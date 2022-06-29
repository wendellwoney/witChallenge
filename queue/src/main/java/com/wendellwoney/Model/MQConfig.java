package com.wendellwoney.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class MQConfig {
    private String queueSend;
    private String queueListen;
    private String exchange;
}
