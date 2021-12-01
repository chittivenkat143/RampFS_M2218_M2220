package com.hcl.training.pojos.finance;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Branch {
	private String branchName;
	private String branchIfsc;
	public Branch(String branchName, String branchIfsc) {
		this.branchName = branchName;
		this.branchIfsc = branchIfsc;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchIfsc() {
		return branchIfsc;
	}
	public void setBranchIfsc(String branchIfsc) {
		this.branchIfsc = branchIfsc;
	}
	
}
