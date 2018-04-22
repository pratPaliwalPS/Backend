package com.obs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;

@SpringBootApplication(exclude = JmsAutoConfiguration.class)
public class SwaggerTestApplication {

	public static void main(String[] args) {
		

		SpringApplication.run(SwaggerTestApplication.class, args);
		
		
	}
}
