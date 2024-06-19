package com.korsakov.cityapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CityAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(CityAppApplication.class, args);
	}
}
