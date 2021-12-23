package com.hcl.employee.fegin;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hcl.employee.entity.Activity;

@FeignClient(name = "activities-service", url = "http://localhost:8081/activity")
public interface ActivityFeginClient {

	@GetMapping("/activitiesByCode/{employeeCode}")
	public List<Activity> getActivitiesByCode(@PathVariable("employeeCode") Integer employeeCode);
	
}
