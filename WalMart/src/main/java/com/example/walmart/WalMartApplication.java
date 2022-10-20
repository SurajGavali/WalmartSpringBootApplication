package com.example.walmart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WalMartApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalMartApplication.class, args);
    }

}
