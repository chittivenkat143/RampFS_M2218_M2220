package com.hcl.employee.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "employee")
public class Employee implements Serializable{
	private static final long serialVersionUID = 2474281944687803726L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Integer employeeId;
	
	@Column(name = "name")
	private String name;
	
	@NaturalId(mutable = true)
	@Column(name="code", unique = true)
	private Integer code;
	
	@NotEmpty(message = "Project should not be empty")
	@Column(name = "project_status")
	private String project;
	
	@NotEmpty(message = "Email should not be empty")
	@Email(message = "Please provide valid Email")
	@Column(name = "email_id", unique = true)
	private String mailId;
	
	@Column(name = "phone_number", unique = true)
	private String phoneNo;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
	private List<Activity> activities = new ArrayList<>();
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", empCode=" + code + ", project=" + project
				+ ", mailId=" + mailId + ", phoneNo=" + phoneNo + "]";
	}
	
}
