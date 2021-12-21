package com.hcl.services.bank;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
class BankServicesApplicationTests {
	
	//@Mock
	//ConfigurableApplicationContext context;

	@Test
	void contextLoads() {
		System.out.println("Test Done");
	}
	
//	@BeforeEach
//	void setUp() throws Exception {
//		context = new ClassPathXmlApplicationContext("pathtoxml.xml");
//	}
//
//	@Test
//	final void testMain() {
//		when(SpringApplication.run(BankServicesApplication.class, new String[] {})).thenReturn(context);
//		BankServicesApplication.main(new String[] {});
//	}
}
