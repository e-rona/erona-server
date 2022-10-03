package com.sg.erona.interfaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class EronaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EronaApplication.class, args);
    }
}
