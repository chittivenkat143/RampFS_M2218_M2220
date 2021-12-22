package com.hcl.employee.dto;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransactionDto {
	
	private Long transactionId;
	private String transactionNumber;
	private Date transactionOn;
	private Double transactionAmount;
	private Integer transactionType;
	private Long transactionAccountId;
	private String transactionAccountNumber;
	private String transactionstate;

}
