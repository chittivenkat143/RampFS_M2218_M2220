package com.hcl.employee.config;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hcl.employee.fegin.BankFeginClient;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

@Configuration
public class ApplicationConfiguration {
	
	@Bean
	public CircuitBreakerConfig circuitBreakerConfig() {
		return CircuitBreakerConfig.custom()
				.slidingWindowType(SlidingWindowType.COUNT_BASED)
				.slidingWindowSize(10)
				.failureRateThreshold(25.0f)
				.waitDurationInOpenState(Duration.ofSeconds(10))
				.permittedNumberOfCallsInHalfOpenState(4)
				.build();
	}
	
	@Bean
	public CircuitBreakerRegistry circuitBreakerRegistry() {
		return CircuitBreakerRegistry.of(circuitBreakerConfig());
	}
	
	@Bean
	public CircuitBreaker circuitBreaker() {
		return circuitBreakerRegistry().circuitBreaker(BankFeginClient.CB_BANK_SERVICE);
	}
	
}
