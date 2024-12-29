package com.edu.pantrypal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.edu.pantrypal.rest.controller")
public class PantrypalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PantrypalApplication.class, args);
	}

}
