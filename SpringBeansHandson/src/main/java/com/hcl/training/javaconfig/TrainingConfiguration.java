package com.hcl.training.javaconfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.hcl.training.pojos.Department;
import com.hcl.training.pojos.Faculty;

@Configuration
public class TrainingConfiguration {
	
	@Bean
	public Department getDepartment() {
		return new Department();
	}
	
	@Qualifier(value = "research")
	@Bean
	public Department getDepartmentResearch() {
		return new Department("Research", 3);
	}
	
	@Bean
	public Faculty getFaculty() {
		return new Faculty();
	}
	
	@Primary
	@Bean
	public Faculty getFacultyComputers() {
		return new Faculty("Ram", "Computer", 3);
	}
}
