package com.rbank.services.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PlatformEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatformEurekaServiceApplication.class, args);
	}
}
