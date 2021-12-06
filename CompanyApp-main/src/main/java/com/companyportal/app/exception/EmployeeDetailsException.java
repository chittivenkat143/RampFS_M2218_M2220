package com.companyportal.app.exception;

public class EmployeeDetailsException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private String exceptionMessage;

	public EmployeeDetailsException(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
}
