package com.hcl.employee.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountRequestDTO {

	private Long accountId;

	private Integer accountCode;

	private Integer accountCustomerId;

	private Double accountBalance;
}
