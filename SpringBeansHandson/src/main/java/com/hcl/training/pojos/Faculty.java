package com.hcl.training.pojos;

import java.util.Set;

public class Faculty {
	private String name;
	private String subject;
	private Integer experience;
	
	private Set<Department> departments;
	
	public Faculty() {}

	public Faculty(String name, String subject, Integer experience) {
		this.name = name;
		this.subject = subject;
		this.experience = experience;
	}
	
	public Faculty(String name, String subject, Integer experience, Set<Department> departments) {
		this.name = name;
		this.subject = subject;
		this.experience = experience;
		this.departments = departments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	
	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "Faculty [name=" + name + ", subject=" + subject + ", experience=" + experience + "]";
	}
	
	
}
