package com.sg.erona.interfaces;

import com.sg.erona.domain.EronaDomainApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;


@PropertySource("classpath:erona-interfaces.properties")
@Slf4j
@EnableCaching
@ServletComponentScan
@SpringBootApplication
public class EronaApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(EronaDomainApplication.class, EronaApplication.class)
                .run(args);
    }
}
