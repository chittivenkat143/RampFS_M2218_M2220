package com.hcl.services.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

@Configuration
public class ApplicationConfiguration {
	
	@Bean
	public Faker getFaker() {
		return new Faker();
	}

}
