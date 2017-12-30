package com.rbank.domain.retail.services.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomerAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerAccountServiceApplication.class, args);
	}
}
