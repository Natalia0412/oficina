package com.example.oficina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class OficinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OficinaApplication.class, args);
	}

}
