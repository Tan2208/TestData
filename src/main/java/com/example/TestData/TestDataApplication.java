package com.example.TestData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class TestDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestDataApplication.class, args);
	}

}
