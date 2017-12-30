package com.rbank.services.platform;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class SampleCloudConfigClientApplication {
    @Value("${property.name.git:Default value for property.name.git}")
    String bar;

    
    @Value("${property.name:Default Welcome Message!}")
    String welcomeMessage;
    
    @RequestMapping("/hello")
    String hello() {
        return "Property Key (bar) : Value :" + bar + "         |       Property Key (welcome.message) : Value : " + welcomeMessage;
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleCloudConfigClientApplication.class, args);
    }
}