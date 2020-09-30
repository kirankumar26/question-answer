package com.coding.excercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ExcerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcerciseApplication.class, args);
	}

}
