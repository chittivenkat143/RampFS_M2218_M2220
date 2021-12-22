package com.hcl.employee.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDto {
	private Long customerId;

	private String customerName;

	private String customerMobile;

	private String customerEmail;

	private String customerUsername;

	private String customerPassword;

	private String customerAddress;

	private Integer customerType;

	private Date customerCreatedOn;

	private Integer customerStatus;

	private List<AccountDto> accounts; // Getting infinite recursive loop
}
