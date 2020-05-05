package com.customer.rewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = { "com.customer.rewards" })
@Configuration
@ComponentScan(basePackages = { "com.customer.rewards" })
@EnableSwagger2
public class CustomerRewardsApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(CustomerRewardsApplication.class, args);
	}

}
