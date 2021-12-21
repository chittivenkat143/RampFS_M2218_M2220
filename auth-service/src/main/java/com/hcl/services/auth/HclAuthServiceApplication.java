package com.hcl.services.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hcl.services.auth.repo.LoginUserRepository;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories(basePackageClasses = LoginUserRepository.class)
public class HclAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HclAuthServiceApplication.class, args);
	}

}
