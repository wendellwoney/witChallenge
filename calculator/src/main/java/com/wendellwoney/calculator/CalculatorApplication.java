package com.wendellwoney.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(scanBasePackages = "com.wendellwoney")
@PropertySources({
        @PropertySource("classpath:calculator.properties"),
        @PropertySource("classpath:queue.properties")
})
public class CalculatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }
}