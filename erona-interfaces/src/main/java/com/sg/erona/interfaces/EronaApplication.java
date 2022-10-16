package com.sg.erona.interfaces;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
@EnableCaching
//@ServletComponentScan
@ComponentScan({ "com.sg.erona.*" })
@SpringBootApplication
//TODO : DB 연결 후 수정
public class EronaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EronaApplication.class, args);
    }
}
