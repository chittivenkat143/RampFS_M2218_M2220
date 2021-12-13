package com.hcl.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.employee.entity.Employee;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Integer>{

}
