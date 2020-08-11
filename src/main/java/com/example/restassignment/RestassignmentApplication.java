package com.example.restassignment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.restassignment")
public class RestassignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestassignmentApplication.class, args);
	}

}
