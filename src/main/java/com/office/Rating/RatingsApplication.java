package com.office.Rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RatingsApplication {


	public static void main(String[] args) {
		SpringApplication.run(RatingsApplication.class, args);
	}

}
