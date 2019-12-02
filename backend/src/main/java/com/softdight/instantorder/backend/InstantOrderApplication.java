package com.softdight.instantorder.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.softdight.instantorder.backend")
public class InstantOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstantOrderApplication.class, args);
    }

}
