package com.hcl.services.bank;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hcl.services.bank.domain.concrete.TransferContext;

@SpringBootApplication
public class BankServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServicesApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public TransferContext getTransferContext() {
		return new TransferContext();
	}

}
