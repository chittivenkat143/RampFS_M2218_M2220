package com.hcl.training.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.hcl.training.pojos.Apple;
import com.hcl.training.pojos.Micromax;

@Configuration
public class JavaBasedBeanConfiguation {
	
	@Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
	public Micromax getMicromax() {
		return new Micromax();
	}
	
	@Bean
	@Scope("prototype") /*singleton will return same instance for each context*/
	public Apple getApple() {
		return new Apple();
	}
}
