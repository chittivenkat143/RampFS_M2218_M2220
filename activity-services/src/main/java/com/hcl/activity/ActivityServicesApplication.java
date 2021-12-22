package com.hcl.activity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ActivityServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityServicesApplication.class, args);
	}

}
