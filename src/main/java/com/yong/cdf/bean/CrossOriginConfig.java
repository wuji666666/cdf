package com.yong.cdf.bean;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossOriginConfig implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8088")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedMethods("*");
        WebMvcConfigurer.super.addCorsMappings(registry);
    }
}

