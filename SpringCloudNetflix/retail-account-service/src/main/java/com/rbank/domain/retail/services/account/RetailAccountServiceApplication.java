package com.rbank.domain.retail.services.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RetailAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailAccountServiceApplication.class, args);
	}
}
