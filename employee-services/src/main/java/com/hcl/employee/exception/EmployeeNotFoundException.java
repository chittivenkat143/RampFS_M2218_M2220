package com.hcl.employee.exception;

public class EmployeeNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private String exceptionMessage;

	public EmployeeNotFoundException(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
}
