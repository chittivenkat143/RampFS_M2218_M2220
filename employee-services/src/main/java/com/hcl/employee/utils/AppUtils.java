package com.hcl.employee.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppUtils {
	private static AppUtils instance;

	public static AppUtils getInstance() {
		if(instance==null) {
			return instance = new AppUtils();
		}
		return instance;
	}
	
	public String getLocalDateTime() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
	}
	
}
