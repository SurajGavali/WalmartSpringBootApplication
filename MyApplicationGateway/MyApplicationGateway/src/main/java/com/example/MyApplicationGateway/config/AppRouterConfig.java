package com.example.MyApplicationGateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppRouterConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){


        return builder.routes()
                .route("user",r->r.path("/walmart/users/**").uri("http://localhost:8085/walmart"))
                .route("ResultProducts",r->r.path("/walmart/").uri("http://localhost:8083/products"))
                .build();
    }
}
