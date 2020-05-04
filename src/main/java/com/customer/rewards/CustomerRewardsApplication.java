package com.customer.rewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.customer.rewards")
public class CustomerRewardsApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(CustomerRewardsApplication.class, args);
	}


}
