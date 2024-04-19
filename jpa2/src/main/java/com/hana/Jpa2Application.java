package com.hana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Jpa2Application {

	public static void main(String[] args) {
		SpringApplication.run(Jpa2Application.class, args);
	}

}
