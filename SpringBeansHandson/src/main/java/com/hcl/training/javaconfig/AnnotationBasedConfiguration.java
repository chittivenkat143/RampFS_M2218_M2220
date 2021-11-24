package com.hcl.training.javaconfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.hcl.training.pojos.Carrom;
import com.hcl.training.pojos.CarromType;
import com.hcl.training.pojos.Cricket;

//@Configuration
public class AnnotationBasedConfiguration {
	
	@Bean
	public Cricket getCricket() {
		return new Cricket();
	}
	
	@Bean
	@Qualifier("single")
	public CarromType getCarromTypeSingle() {
		return CarromType.SINGLE;
	}
	
	@Bean
	@Qualifier("double")
	public CarromType getCarromTypeDouble() {
		return CarromType.DOUBLE;
	}
	
	@Bean
	@Scope(value = "prototype")
	public Carrom getCarrom(@Qualifier("double") CarromType carromType) {
		return new Carrom(carromType);
	}

}
