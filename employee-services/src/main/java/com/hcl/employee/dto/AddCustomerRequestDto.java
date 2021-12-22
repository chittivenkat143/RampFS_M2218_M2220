package com.hcl.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequestDto {
	private CustomerRequestDTO customerDto;
	private Integer employeeId;
}
