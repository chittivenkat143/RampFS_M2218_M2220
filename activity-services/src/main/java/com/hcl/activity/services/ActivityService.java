package com.hcl.activity.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.activity.entity.Activity;
import com.hcl.activity.interfaces.IActivityService;
import com.hcl.activity.repo.ActivityRepository;

@Service
public class ActivityService implements IActivityService{

	private ActivityRepository activityRepository;

	@Override
	public Activity saveOrUpdateActivityForEmployee(Integer employeeCode, Activity activity) {
		return activityRepository.save(activity);
	}

	@Override
	public List<Activity> getActivitiesByEmployeeCode(Integer employeeCode) {
		return activityRepository.findAllByCode(employeeCode);
	}

	@Override
	public void deleteActivityById(Integer activityId) {
		activityRepository.deleteById(activityId);
	}

}
