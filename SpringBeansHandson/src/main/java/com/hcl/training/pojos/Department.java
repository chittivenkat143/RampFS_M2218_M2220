package com.hcl.training.pojos;

import java.util.Set;

public class Department {
	private String name;
	private Integer facultyCount;
	private Set<Faculty> faculties;
	
	public Department() {
	}

	public Department(String name, Integer facultyCount) {
		this.name = name;
		this.facultyCount = facultyCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFacultyCount() {
		return facultyCount;
	}

	public void setFacultyCount(Integer facultyCount) {
		this.facultyCount = facultyCount;
	}
	
	public Set<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(Set<Faculty> faculties) {
		this.faculties = faculties;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", facultyCount=" + facultyCount + "]";
	}
	
	public void initMethod() {
		System.out.println("Init Method from Department class");
	}
	
	public void destroyMethod() {
		System.out.println("Destroy Method from Department class");
	}
	
}
