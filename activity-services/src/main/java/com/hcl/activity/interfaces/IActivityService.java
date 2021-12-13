package com.hcl.activity.interfaces;

import java.util.List;

import com.hcl.activity.entity.Activity;

public interface IActivityService {
	public Activity saveOrUpdateActivityForEmployee(Integer employeeCode, Activity activity);
	
	public List<Activity> getActivitiesByEmployeeCode(Integer employeeCode);
	
	public void deleteActivityById(Integer activityId);
}
