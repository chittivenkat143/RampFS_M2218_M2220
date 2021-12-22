package com.hcl.employee.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountTypeDto {
	private Long accountCode;
	private String accountName;
	private String accountDescription;
}
