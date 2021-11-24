package com.hcl.training.pojos;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class Micromax implements Phone, BeanPostProcessor{
	
	String model = "Mx Pro";
	
	public void initMethod() {
		System.out.println("Init Method from Micromax class");
	}
	
	public void destroyMethod() {
		System.out.println("Destroy Method from Micromax class");
	}
	
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BPP: Logic Before Bean Initialization");
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BPP: Logic After Bean Initialization");
		model = "Mx Pro Ultra";
		return bean;
	}

	public String company() {
		return "Micromax inc.";
	}

	public String model() {
		return model;
	}

	public String os() {
		return "Android";
	}

	public Integer version() {
		return 9;
	}

	public List<String> featuresSupport() {
		return Arrays.asList("SMS", "EMAIL", "VOICE CALL", "VIDEO CALL", "INTERNET", "MAP", "BLUETOOTH");
	}

	@Override
	public String toString() {
		return "Micromax [company()=" + company() + ", model()=" + model() + ", os()=" + os() + ", version()="
				+ version() + ", featuresSupport()=" + featuresSupport() + "]";
	}

}
