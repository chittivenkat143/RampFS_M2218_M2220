package com.hcl.employee.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hcl.employee.entity.Activity;

public class EmployeeDTO {
	
	@JsonProperty(required = true)
	private Integer employeeId;

	@NotEmpty(message = "Name should not be empty")
	@JsonProperty(required = true)
	private String name;
	
	@NotNull(message = "Code should not be empty")
	@JsonProperty(required = true)
	private Integer code;
	
	@NotEmpty(message = "Project should not be empty")
	@JsonProperty(required = true)
	private String project;
	
	@NotEmpty(message = "Email should not be empty")
	@Email(message = "Please provide valid Email")
	@JsonProperty(required = true)
	private String mailId;
	
	@NotEmpty(message = "Email should not be empty")
	@Size(min = 10, max = 10, message = "Phone number should be 10 digits")
	@JsonProperty(required = true)
	private String phoneNo;
	
	@JsonProperty(required = true)
	private List<Activity> activities;
	
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	
}
