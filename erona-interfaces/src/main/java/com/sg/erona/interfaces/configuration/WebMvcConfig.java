package com.sg.erona.interfaces.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final JwtIntercepter jwtIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("{}====>addInterceptors", registry);
        registry.addInterceptor(jwtIntercepter)
                .excludePathPatterns("/css/**", "/images/**", "/js/**", "/login/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        log.info("{}====>addCorsMappings", registry);
        registry
                .addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowCredentials(false)
                .maxAge(3000);
    }

}
