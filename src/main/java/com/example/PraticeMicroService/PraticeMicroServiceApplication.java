package com.example.PraticeMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PraticeMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PraticeMicroServiceApplication.class, args);
	}

}
