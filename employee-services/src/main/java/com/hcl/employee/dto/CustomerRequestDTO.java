package com.hcl.employee.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerRequestDTO {
	private Long customerId;

	private String customerName;

	private String customerMobile;

	private String customerEmail;

	private String customerUsername;

	private String customerPassword;

	private String customerAddress;

	private Integer customerType;// General(0), Wealth(1)
	private Integer customerStatus;// Active(0) , Inactive(1), Closed(2), Hold(3)
}
