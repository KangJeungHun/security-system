package com.example.security_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SecuritySystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(SecuritySystemApplication.class, args);
	}
}