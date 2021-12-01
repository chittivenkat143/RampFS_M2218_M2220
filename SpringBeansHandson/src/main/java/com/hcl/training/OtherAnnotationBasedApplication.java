package com.hcl.training;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hcl.training.components.BranchService;
import com.hcl.training.javaconfig.FinanceBeanConfigaration;

public class OtherAnnotationBasedApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();
		
		context.register(FinanceBeanConfigaration.class);
		context.refresh();
		
		BranchService branch = (BranchService) context.getBean(BranchService.class);
		BranchService branch2 = (BranchService) context.getBean(BranchService.class);
		
		System.out.println(branch + "\n" + branch2);
		System.out.println(branch.getBranch() + "\n" + branch2.getBranch());
		
	}
}
