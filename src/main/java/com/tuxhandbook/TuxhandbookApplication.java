package com.tuxhandbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TuxhandbookApplication {
    public static void main(String[] args) {
        SpringApplication.run(TuxhandbookApplication.class, args);
    }
}
