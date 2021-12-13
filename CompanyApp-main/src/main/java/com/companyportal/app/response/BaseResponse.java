package com.companyportal.app.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class BaseResponse extends ResponseEntity<Object>{
	
	private HttpStatus status;
	private Object response;
	MultiValueMap<String, String> headers;
	
	public BaseResponse(HttpStatus status) {
		//super(status);
		this(null, status);
	}

	public BaseResponse(Object body, HttpStatus status) {
		//super(body, status);
		this(body, null,status);
	}

	public BaseResponse(MultiValueMap<String, String> headers, HttpStatus status) {
		super(headers, status);
		this.status = status;
		this.headers = headers;
	}

	public BaseResponse(Object body, MultiValueMap<String, String> headers, HttpStatus status) {
		super(body, headers, status);
		this.status=status;
		this.response=body;
		this.headers=headers;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
}
