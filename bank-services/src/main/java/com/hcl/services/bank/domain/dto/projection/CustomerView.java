package com.hcl.services.bank.domain.dto.projection;

import java.util.Date;
import java.util.List;

public interface CustomerView {
	public Long getCustomerId();
	public String getCustomerName();
	public String getCustomerMobile();
	public String getCustomerEmail();
	public String getCustomerUsername();
	public String getCustomerPassword();
	public String getCustomerAddress();
	public Integer getCustomerType();
	public Date getCustomerCreatedOn();
	public Integer getCustomerStatus();
	public List<AccountView> getAccounts();
}