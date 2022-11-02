package com.example.walmart.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class FeignConfig {

    @Value("${api.key}")
    private String apikey;
    @Value("${api.host}")
    private String hostname;

    @Bean
    public RequestInterceptor requestInterceptor(){

        return requestTemplate -> {
            requestTemplate.header("X-RapidAPI-Key",apikey);
            requestTemplate.header("X-RapidAPI-Host",hostname);
        };
    }
}
