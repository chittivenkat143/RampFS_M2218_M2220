package com.hcl.training.components;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import com.hcl.training.pojos.finance.Branch;

@Component
public class BranchService {
	
	@Lookup
	public Branch getBranch() {
		return new Branch("HITECH", "SBI85856");
	}

}
