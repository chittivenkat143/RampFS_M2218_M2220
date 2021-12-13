package com.hcl.activity.dto;

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

	public Integer getEmpCode() {
		return empCode;
	}

	public void setEmpCode(Integer empCode) {
		this.empCode = empCode;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
