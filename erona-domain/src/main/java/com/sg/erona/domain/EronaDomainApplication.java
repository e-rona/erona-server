package com.sg.erona.domain;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;


@PropertySource("classpath:erona-domain.properties")
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableAsync
public class EronaDomainApplication {
}
