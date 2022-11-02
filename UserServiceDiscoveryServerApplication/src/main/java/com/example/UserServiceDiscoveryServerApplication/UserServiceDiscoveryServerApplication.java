package com.example.UserServiceDiscoveryServerApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class UserServiceDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceDiscoveryServerApplication.class, args);
	}

}
