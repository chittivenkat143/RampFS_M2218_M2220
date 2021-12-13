package com.hcl.employee.dto;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivityDTO {
	
	@NotEmpty(message = "Employee Code should not be empty")
	@JsonProperty(required = true)
	private Integer empCode;
	
	@NotEmpty(message = "Creation date must")
	@JsonProperty(required = true)
	private Date datetime;
	
	@NotEmpty(message = "Description should not be empty")
	@JsonProperty(required = true)
	private String description;
	
	@NotEmpty(message = "Statu should not be empty")
	@JsonProperty(required = true)
	private String status;
}
