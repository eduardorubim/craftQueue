package com.application.craftqueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ApiApp {
    
    public static void main(String[] args) {
        SpringApplication.run(ApiApp.class, args);
    }
    
}
