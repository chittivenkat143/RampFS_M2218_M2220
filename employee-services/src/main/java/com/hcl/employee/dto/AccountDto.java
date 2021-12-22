package com.hcl.employee.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDto {
	private Long accountId;
	private String accountNumber;
	private Date accountCreatedOn;
	private AccountTypeDto accountCode;
	private CustomerDto accountCustomerId;
	private Double accountBalance;
	private List<TransactionDto> transactions;
}
