package com.hana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Openapi2Application {

    public static void main(String[] args) {
        SpringApplication.run(Openapi2Application.class, args);
    }

}
