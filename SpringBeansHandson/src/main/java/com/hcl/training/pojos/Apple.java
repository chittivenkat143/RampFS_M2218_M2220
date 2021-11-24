package com.hcl.training.pojos;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Apple implements Phone, InitializingBean, DisposableBean{

	public String company() {
		return "Apple Inc.";
	}

	public String model() {
		return "SX Pro Max";
	}

	public String os() {
		return "IOS";
	}

	public Integer version() {
		return 11;
	}

	public List<String> featuresSupport() {
		return Arrays.asList("SMS", "EMAIL", "VOICE CALL", "VIDEO CALL", "INTERNET", "MAP", "ITUNES");
	}

	public String toStringPrint() {
		return "Apple [company()=" + company() + ", model()=" + model() + ", os()=" + os() + ", version()=" + version()
				+ ", featuresSupport()=" + featuresSupport() + "]";
	}

	public void destroy() throws Exception {
		System.out.println("destroy(): Destroy Method from Apple class");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet(): Init Method from Apple class");
	}

}