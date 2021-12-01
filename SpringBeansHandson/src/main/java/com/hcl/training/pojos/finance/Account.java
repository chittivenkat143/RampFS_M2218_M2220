package com.hcl.training.pojos.finance;

import org.springframework.beans.factory.annotation.Autowired;

public class Account {
	private String accountNo;
	private String accountType;
	private Customer customer;
	
	public Account(String accountNo, String accountType) {
		this.accountNo = accountNo;
		this.accountType = accountType;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Customer getCustomer() {
		return customer;
	}
	
	@Autowired
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
