package com.hcl.training.pojos;

import java.util.List;

public class Orgination {
	private String name;
	private String address;
	private List<Department> departments;
	
	public Orgination() {}
	
	public Orgination(String name, String address) {
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "Orgination [name=" + name + ", address=" + address + "]";
	}
	
}
