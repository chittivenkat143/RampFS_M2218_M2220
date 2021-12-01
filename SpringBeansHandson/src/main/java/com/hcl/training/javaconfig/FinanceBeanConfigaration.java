package com.hcl.training.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.hcl.training.components.BranchService;
import com.hcl.training.pojos.finance.Branch;

@Configuration
public class FinanceBeanConfigaration {
	
	@Bean("branch")
	public Branch getBranch() {
		return new Branch("KBHP", "SBI002336");
	}
	
	@Bean
	public BranchService getBranchService() {
		return new BranchService(); 
	}

}
