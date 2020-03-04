package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com")
public class OutreachAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OutreachAppApplication.class, args);
	
	}

}
